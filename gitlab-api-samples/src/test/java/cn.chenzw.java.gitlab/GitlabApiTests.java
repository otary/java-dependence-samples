package cn.chenzw.java.gitlab;

import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.util.IOTools;
import org.apache.commons.io.IOUtils;
import org.gitlab4j.api.Constants;
import org.gitlab4j.api.GitLabApi;
import org.gitlab4j.api.GitLabApiException;
import org.gitlab4j.api.models.Branch;
import org.gitlab4j.api.models.FileUpload;
import org.gitlab4j.api.models.Project;
import org.gitlab4j.api.models.RepositoryFile;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.List;

/**
 * @author chenzw
 */
@Slf4j
@RunWith(JUnit4.class)
public class GitlabApiTests {

    @Test
    public void test() throws GitLabApiException, IOException {
        // 配置你的GitLab服务器信息
        GitLabApi gitLabApi = new GitLabApi("http://10.11.2.113:8081", "glpat-kAE9ctEJ_xt8x_FK4xx1");

        // 获取项目列表
        List<Project> projects = gitLabApi.getProjectApi().getProjects();
        log.info("projects => {}", projects);

        //获取分支列表
        List<Branch> branches = gitLabApi.getRepositoryApi().getBranches(844L);
        log.info("branches => {}", branches);

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
}
