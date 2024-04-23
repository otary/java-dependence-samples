package cn.chenzw.dependence.lombok.domain.superbuilder;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@ToString
@SuperBuilder
public class Children extends Father{

    private String cName;

    private String cAge;


}
