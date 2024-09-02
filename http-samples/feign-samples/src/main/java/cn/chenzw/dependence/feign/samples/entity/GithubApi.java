package cn.chenzw.dependence.feign.samples.entity;

import feign.Headers;
import feign.RequestLine;

/**
 * @author chenzw
 */
public interface GithubApi {

    @Headers({"Authorization: token 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"})
    @RequestLine("GET /user")
    String getCurrentUser();


}
