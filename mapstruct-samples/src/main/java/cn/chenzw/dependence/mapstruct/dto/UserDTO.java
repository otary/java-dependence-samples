package cn.chenzw.dependence.mapstruct.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserDTO {

    private Long id;

    private String name;

    private String nickName;

    private Date createTime;
}
