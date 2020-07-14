package cn.chenzw.dependence.jackson.samples.domain.entity;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data
@ToString
public class User {

    private Long id;
    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birth;

    /**
     * 未映射的属性值放到此Map上
     */
    @JsonAnySetter
    private Map<String, Object> ext = new HashMap<>();

    /**
     * 字段值不映射
     */
    @JsonIgnore
    private String sex;


}
