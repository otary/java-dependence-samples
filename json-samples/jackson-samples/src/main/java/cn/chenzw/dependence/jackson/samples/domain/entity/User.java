package cn.chenzw.dependence.jackson.samples.domain.entity;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class User {

    private Long id;

    /**
     * 字段重命名
     */
    @JsonProperty("userName")
    private String name;

    private List<Mobile> mobiles;

    /**
     * 只写，不读
     */
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    /**
     * 忽略字段
     */
    @JsonIgnore
    private String remark;

    private String nickName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthDate;

    /**
     * 不转换格式（全局转换）
     */
    private Date hapyyDate;


    private BigDecimal money;


    private Double height;

    /**
     * 未映射的属性值放到此Map上
     */
    @JsonAnySetter
    private Map<String, Object> ext = new HashMap<>();

    @Data
    @NoArgsConstructor
    public static class Mobile {

        private Long id;

        private String no;

        public Mobile(Long id, String no) {
            this.id = id;
            this.no = no;
        }
    }

}
