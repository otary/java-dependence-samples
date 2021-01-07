package cn.chenzw.dependence.gson.domain;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Since;
import com.google.gson.annotations.Until;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class User {

    private Long id;

    /**
     * 字段重命名
     */
    @SerializedName("userName")
    private String name;

    private List<Mobile> mobiles;

    /**
     * 忽略字段
     */
    private transient String password;

    private String nickName;

    /**
     * 可以使用@JsonAdapter来指定日期格式
     */
    private Date birthDate;

    /**
     * 2.3+版本才使用此字段（使用setVersion()指定版本，未指定版本默认可用）
     */
    @Since(2.3)
    private BigDecimal money;

    /**
     * 1.5-版本才使用此字段（使用setVersion()指定版本，未指定版本默认可用）
     */
    @Until(1.5)
    private Double height;

    @Data
    public static class Mobile {

        private Long id;

        private String no;

        public Mobile(Long id, String no) {
            this.id = id;
            this.no = no;
        }
    }
}
