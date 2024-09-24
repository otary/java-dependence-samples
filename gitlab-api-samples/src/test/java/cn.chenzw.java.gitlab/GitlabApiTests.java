package cn.chenzw.java.gitlab;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.gitlab4j.api.Constants;
import org.gitlab4j.api.GitLabApi;
import org.gitlab4j.api.GitLabApiException;
import org.gitlab4j.api.models.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
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

    @Test
    public void testGetInfo() throws GitLabApiException {
        // 配置你的GitLab服务器信息
        GitLabApi gitLabApi = new GitLabApi(gitlabHostURL, personalAccessToken);

        // 获取项目列表
        List<Project> projects = gitLabApi.getProjectApi().getProjects();
        log.info("projects => {}", projects);

        //获取分支列表
        List<Branch> branches = gitLabApi.getRepositoryApi().getBranches(844L);
        log.info("branches => {}", branches);
    }

    @Test
    public void testUpload() throws IOException, GitLabApiException {
        GitLabApi gitLabApi = new GitLabApi(gitlabHostURL, personalAccessToken);
        // 新建文件
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("gitlabApi.zip");
        String str = Base64.getEncoder().encodeToString(IOUtils.toByteArray(is));
        RepositoryFile repositoryFile = new RepositoryFile();
        repositoryFile.setContent(str);
        repositoryFile.setEncoding(null);
        repositoryFile.setFilePath("t.zip");
        repositoryFile.setEncoding(Constants.Encoding.BASE64);
        gitLabApi.getRepositoryFileApi().createFile(844L, repositoryFile, "master", "文件上传");

        // 上传文件？
        File file = new File(
                Thread.currentThread().getContextClassLoader().getResource("test.txt").getFile()
        );
        FileUpload fileUpload = gitLabApi.getProjectApi().uploadFile(844L, file);

        log.info("fileUpload => {}", fileUpload);
    }

    @Test
    public void testProjectStats() throws GitLabApiException {
        GitLabApi gitLabApi = new GitLabApi(gitlabHostURL, personalAccessToken);
        Project project = gitLabApi.getProjectApi().getProject("1076", true);
        log.info("LfsObjectsSize => {}", project.getStatistics().getLfsObjectsSize());
        log.info("PackagesSize => {}", project.getStatistics().getPackagesSize());
        log.info("StorageSize => {}", project.getStatistics().getStorageSize());
        log.info("RepositorySize => {}", project.getStatistics().getRepositorySize());
        log.info("CommitCount => {}", project.getStatistics().getCommitCount());
        log.info("JobArtifactsSize => {}", project.getStatistics().getJobArtifactsSize());
        log.info("WikiSize => {}", project.getStatistics().getWikiSize());
    }

    @Test
    public void testTree() throws GitLabApiException {
        GitLabApi gitLabApi = new GitLabApi(gitlabHostURL, personalAccessToken);
        List<TreeItem> treeItems = gitLabApi.getRepositoryApi()
                .getTree("1126", "/", "master", true);
        log.info("treeItems => {}", treeItems);
    }

    @Test
    public void testCommits() throws GitLabApiException {
        GitLabApi gitLabApi = new GitLabApi(gitlabHostURL, personalAccessToken);
        List<Commit> commits = gitLabApi.getCommitsApi().getCommits("1076");
        log.info("commits => {}", commits);
    }

    @Test
    public void testCreateGroup() throws GitLabApiException {
        GitLabApi gitLabApi = new GitLabApi(gitlabHostURL, personalAccessToken);
        GroupParams groupParams = new GroupParams()
                .withName("myGroup")
                .withPath("xxx");
        Group newGroup = gitLabApi.getGroupApi().createGroup(groupParams);
        log.info("group => {}", newGroup);
    }

    @Test
    public void testGetGroup() throws GitLabApiException {
        GitLabApi gitLabApi = new GitLabApi(gitlabHostURL, personalAccessToken);
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

    @Test
    public void testCreateProject() throws GitLabApiException {
        GitLabApi gitLabApi = new GitLabApi(gitlabHostURL, personalAccessToken);

        Project project = new Project()
                .withName("test")
                .withDescription("项目描述")
                .withNamespaceId(1837)  // GroupId
                .withPublic(false);
        Project newProject = gitLabApi.getProjectApi().createProject(project);
        log.info("project => {}", newProject);
    }

    @Test
    public void testGetProject() {
        GitLabApi gitLabApi = new GitLabApi(gitlabHostURL, personalAccessToken);

        // 使用groupPath和projectName查询
        Optional<Project> optional = gitLabApi.getProjectApi().getOptionalProject("xxx", "test");
        if (optional.isPresent()) {
            log.info("project => {}", optional.get());
        } else {
            log.info("project不存在！");
        }
    }

}
