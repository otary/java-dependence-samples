package cn.chenzw.dependence.mapstruct.entity;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class User {

    private Long id;

    private String name;

    private Integer age;

    private Date createTime;
}
