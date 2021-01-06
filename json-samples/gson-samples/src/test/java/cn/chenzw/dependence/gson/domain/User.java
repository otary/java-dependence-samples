package cn.chenzw.dependence.gson.domain;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

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

    private Date birthDate;

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
