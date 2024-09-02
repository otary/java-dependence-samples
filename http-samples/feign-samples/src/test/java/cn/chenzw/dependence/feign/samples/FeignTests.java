package cn.chenzw.dependence.feign.samples;

import cn.chenzw.dependence.feign.samples.entity.GithubApi;
import feign.Feign;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author chenzw
 */
@Slf4j
@RunWith(JUnit4.class)
public class FeignTests {

    @Test
    public void test() {
        GithubApi githubApi = Feign.builder()
                .requestInterceptor(
                        requestTemplate -> log.info("requestTemplate => {}", requestTemplate)
                )
                .target(GithubApi.class, "https://api.github.com");
        String currentUser = githubApi.getCurrentUser();

        log.info("currentUser => {}", currentUser);
    }
}
