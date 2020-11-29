package cn.chenzw.denpendence.lombok.domain.superbuilder;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 *  使用 @SuperBuilder, 子类可以使用父类的属性构建
 */
@Data
@ToString
@SuperBuilder
public class Father {

    private String fName;

    private String fAge;

}
