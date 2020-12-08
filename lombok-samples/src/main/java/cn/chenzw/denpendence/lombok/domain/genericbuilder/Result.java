package cn.chenzw.denpendence.lombok.domain.genericbuilder;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * 泛型构造
 *
 * @param <T>
 */
@Slf4j
@Data
@ToString
@Builder(toBuilder = true)
public class Result<T> {

    /**
     * 指定默认值
     */
    @Builder.Default
    private String code = "200";

    @Builder.ObtainVia(method="success")
    private boolean success;

    private T data;

    private boolean success() {
        log.info("build success value: => " + success);
        return success;
    }
}
