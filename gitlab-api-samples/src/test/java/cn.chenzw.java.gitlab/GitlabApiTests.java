package cn.chenzw.java.gitlab;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.gitlab4j.api.Constants;
import org.gitlab4j.api.GitLabApi;
import org.gitlab4j.api.GitLabApiException;
import org.gitlab4j.api.models.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import sun.reflect.generics.tree.Tree;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

/**
 * @author chenzw
 */
@Slf4j
@RunWith(JUnit4.class)
public class GitlabApiTests {

    private String gitlabHostURL = "http://10.11.2.113:8081";

    private String personalAccessToken = "glpat-zz8zBusSqfFVmRm9HvRr";

    private GitLabApi gitLabApi;

    @Before
    public void before() {
        this.gitLabApi = new GitLabApi(gitlabHostURL, personalAccessToken);
    }

    @Test
    public void testGetInfo() throws GitLabApiException {
        // 获取项目列表
        List<Project> projects = gitLabApi.getProjectApi().getProjects();
        log.info("projects => {}", projects);

        //获取分支列表
        List<Branch> branches = gitLabApi.getRepositoryApi().getBranches(844L);
        log.info("branches => {}", branches);
    }

    @Test
    public void testProjectStats() throws GitLabApiException {
        Project project = gitLabApi.getProjectApi().getProject("1076", true);
        log.info("LfsObjectsSize => {}", project.getStatistics().getLfsObjectsSize());
        log.info("PackagesSize => {}", project.getStatistics().getPackagesSize());
        log.info("StorageSize => {}", project.getStatistics().getStorageSize());
        log.info("RepositorySize => {}", project.getStatistics().getRepositorySize());
        log.info("CommitCount => {}", project.getStatistics().getCommitCount());
        log.info("JobArtifactsSize => {}", project.getStatistics().getJobArtifactsSize());
        log.info("WikiSize => {}", project.getStatistics().getWikiSize());
    }

    /**
     * 创建分组
     */
    @Test
    public void testCreateGroup() throws GitLabApiException {
        GroupParams groupParams = new GroupParams()
                .withName("myGroup")
                .withPath("xxx");
        Group newGroup = gitLabApi.getGroupApi().createGroup(groupParams);
        log.info("group => {}", newGroup);
    }

    /**
     * 判断分组是否存在
     */
    @Test
    public void testGetGroup() throws GitLabApiException {
        Group group = gitLabApi.getGroupApi().getGroup(1837L);
        log.info("group => {}", group);

        // 使用GroupId或GroupPath查询
        Optional<Group> optional = gitLabApi.getGroupApi().getOptionalGroup("xxx");
        if (optional.isPresent()) {
            log.info("group => {}", optional.get());
        } else {
            log.error("group不存在！");
        }
    }

    /**
     * 创建项目
     */
    @Test
    public void testCreateProject() throws GitLabApiException {
        Project project = new Project()
                .withName("test")
                .withDescription("项目描述")
                .withNamespaceId(1837)  // GroupId
                .withPublic(false);
        Project newProject = gitLabApi.getProjectApi().createProject(project);
        log.info("project => {}", newProject);
    }

    /**
     * 判断项目是否存在
     */
    @Test
    public void testGetProject() {
        // 使用groupPath和projectName查询
        Optional<Project> optional = gitLabApi.getProjectApi().getOptionalProject("xxx", "test");
        if (optional.isPresent()) {
            log.info("project => {}", optional.get());
        } else {
            log.info("project不存在！");
        }
    }

    /**
     * 上传文件
     *
     * @throws IOException
     * @throws GitLabApiException
     */
    @Test
    public void testUpload() throws IOException, GitLabApiException {
        // 新建文件
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("gitlabApi.zip");
        String str = Base64.getEncoder().encodeToString(IOUtils.toByteArray(is));
        RepositoryFile repositoryFile = new RepositoryFile();
        repositoryFile.setContent(str);
        repositoryFile.setEncoding(null);
        repositoryFile.setFilePath("t.zip");
        repositoryFile.setEncoding(Constants.Encoding.BASE64);
        gitLabApi.getRepositoryFileApi().createFile(1138L, repositoryFile, "master", "文件上传");

        // 上传文件？
        File file = new File(
                Thread.currentThread().getContextClassLoader().getResource("test.txt").getFile()
        );
        FileUpload fileUpload = gitLabApi.getProjectApi().uploadFile(1138L, file);

        log.info("fileUpload => {}", fileUpload);
    }

    /**
     * 获取项目树
     *
     * @throws GitLabApiException
     */
    @Test
    public void testTree() throws GitLabApiException {
        List<TreeItem> treeItems = gitLabApi.getRepositoryApi()
                .getTree(1138L, "/", "master", true);
        log.info("treeItems => {}", treeItems);
    }

    @Test
    public void testGetCommits() throws GitLabApiException {
        List<Commit> commits = gitLabApi.getCommitsApi().getCommits("1076");
        log.info("commits => {}", commits);
    }

    @Test
    public void testCreateUser() throws GitLabApiException {
        User user = new User()
                .withEmail("yunlives2@qq.com")
                .withUsername("chenzw2")
                .withName("chenzw3")
                .withSkipConfirmation(true);  // 跳过邮件确认

        User newUser = gitLabApi.getUserApi().createUser(user, "Chenzw#321", false);
        log.info("user => {}", newUser);
    }

    @Test
    public void testAddProjectMember() throws GitLabApiException {
        gitLabApi.getProjectApi().addMember(1138L, 283L, AccessLevel.DEVELOPER);
    }

    @Test
    public void testListProjectMembers() throws GitLabApiException {
        List<Member> allMembers = gitLabApi.getProjectApi().getAllMembers(1138L);
        log.info("allMembers => {}", allMembers);
    }

    @Test
    public void testSearchProjectMembers() throws GitLabApiException {
        List<Member> members = gitLabApi.getProjectApi().getAllMembers(1138L, "chenzw", null);
        log.info("members => {}", members);
    }


    /**
     * 创建标签
     */
    @Test
    public void testCreateTag() throws GitLabApiException {
        Tag tag = gitLabApi.getTagsApi().createTag(1138L, "test2", "master");
        log.info("tag => {}", tag);
    }

    /**
     * 获取标签文件
     */
    @Test
    public void testGetTag() throws GitLabApiException {
        Tag tag = gitLabApi.getTagsApi().getTag(1138L, "test2");
        log.info("tags => {}", tag);

        // 根据commitId获取文件列表
        List<TreeItem> treeItems = gitLabApi.getRepositoryApi().getTree(1138L, null, tag.getCommit().getId(), true);
        log.info("tree => {}", treeItems);
    }

    /**
     * 创建合并请求
     */
    @Test
    public void testCreateMergeRequest() throws GitLabApiException {
        MergeRequestParams mrp = new MergeRequestParams()
                .withSourceBranch("feature-branch")  // 源分支名
                .withTargetBranch("master")          // 目标分支名
                .withTitle("Add awesome feature")    // 合并请求标题
                .withDescription("This is an awesome feature that we need to merge into master.") // 描述
                // .withApprovalsBeforeMerge()  // 合并前需要先审批
                // .withAssigneeIds(new ArrayList<>())  // 处理用户ID
                // .withReviewerIds(new ArrayList<>())  // 审核用户ID
                .withRemoveSourceBranch(true);      // 合并后是否删除源分支

        MergeRequest mergeRequest = gitLabApi.getMergeRequestApi().createMergeRequest(1138L, mrp);

        log.info("mergeRequest => {}", mergeRequest);
    }

    /**
     * 获取合并请求列表
     */
    @Test
    public void testGetMergeRequests() throws GitLabApiException {
        List<MergeRequest> mergeRequests = gitLabApi.getMergeRequestApi().getMergeRequests(1138L);
        log.info("mergeRequests => {}", mergeRequests);
    }

    @Test
    public void testFork() throws GitLabApiException {
       /* GroupParams groupParams = new GroupParams()
                .withName("myGroup2")
                .withPath("yyy");
        Group newGroup = gitLabApi.getGroupApi().createGroup(groupParams);
        log.info("group => {}", newGroup);*/
        Project forkProject = gitLabApi.getProjectApi().forkProject(1138L, "yyy");
        log.info("forkProject => {}", forkProject);
    }

    @Test
    public void testFork2() throws GitLabApiException {
        Project forkProject = gitLabApi.getProjectApi().forkProject(1138L, "xxx", "", "fork-test2");
        log.info("forkProject => {}", forkProject);

        Project project = gitLabApi.getProjectApi().getProject(1160L);
        log.info("project => {}", project);
    }

    /**
     * 修改默认分支
     *
     * @throws GitLabApiException
     */
    @Test
    public void testUpdateDefaultBranch() throws GitLabApiException {
        gitLabApi.getProjectApi().updateProject(
                new Project().withDefaultBranch("xxxx")
        );
    }

    @Test
    public void test() {
        gitLabApi.getUserApi().addSshKey()
    }

}
