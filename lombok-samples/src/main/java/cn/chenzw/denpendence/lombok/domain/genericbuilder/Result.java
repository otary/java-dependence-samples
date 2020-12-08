package cn.chenzw.denpendence.lombok.domain.genericbuilder;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * 泛型构造
 *
 * @param <T>
 */
@Data
@ToString
@Builder
public class Result<T> {

    /**
     * 指定默认值
     */
    @Builder.Default
    private String code = "200";

    private T data;
}
