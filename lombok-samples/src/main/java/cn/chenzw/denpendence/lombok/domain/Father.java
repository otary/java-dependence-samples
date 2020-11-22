package cn.chenzw.denpendence.lombok.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Father {

    private String fName;

    private String fAge;

    public Father(String fName, String fAge) {
        this.fName = fName;
        this.fAge = fAge;
    }
}
