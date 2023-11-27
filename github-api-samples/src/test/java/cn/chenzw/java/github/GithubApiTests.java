package cn.chenzw.java.github;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.kohsuke.github.*;

import java.io.IOException;
import java.util.List;

@Slf4j
@RunWith(JUnit4.class)
public class GithubApiTests {

    @Test
    public void test() throws IOException {
        GitHub github = new GitHubBuilder()
                .withOAuthToken("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")
                .build();

        GHRepository repository = github.getRepository("stonelf/zangli");

        log.info("点赞数 => {}", repository.getStargazersCount());
        log.info("Fork数 => {}", repository.getForksCount());
        log.info("监听数 => {}", repository.getWatchersCount());

        log.info("name => {}", repository.getName());
        log.info("full_name => {}", repository.getFullName());
        log.info("作者 => {}", repository.getOwnerName());
        log.info("作者头像 => {}", repository.getOwner().getAvatarUrl());
        log.info("作者首页 => {}", repository.getOwner().getHtmlUrl());
        log.info("作者邮箱 => {}", repository.getOwner().getEmail());
        log.info("URL => {}", repository.getHtmlUrl());
        log.info("描述 => {}", repository.getDescription());

        log.info("License => {}", repository.getLicense().getName());
        log.info("License URL => {}", repository.getLicense().getUrl());
        log.info("ReadME => {}", repository.getFileContent("README.md").getContent());

        log.info("language => {}", repository.getLanguage());
        log.info("创建日期 => {}", repository.getCreatedAt());

    }

    @Test
    public void testUpload() throws IOException {
        GitHub github = new GitHubBuilder()
                .withOAuthToken("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")
                .build();
        GHRepository repository = github.getRepository("otary/git-test");
        repository.createContent()
                .branch("main")
                .path("ttt/a.text")
                .content("内容".getBytes())
                .message("测试")
                .commit();
    }

    @Test
    public void testListRepoFiles() throws IOException {
        GitHub github = new GitHubBuilder()
                .withOAuthToken("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")
                .build();
        GHRepository repository = github.getRepository("otary/git-test");
        List<GHContent> files = repository.getDirectoryContent("/", "main");
        for (GHContent file : files) {
            log.info("file => {} , {}", file.getDownloadUrl(), file.getHtmlUrl());
        }
    }
}
