package cn.chenzw.denpendence.lombok.domain;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Children extends Father{

    private String cName;

    private String cAge;

    @Builder
    public Children(String fName, String fAge, String cName, String cAge) {
        super(fName, fAge);
        this.cName = cName;
        this.cAge = cAge;
    }
}
