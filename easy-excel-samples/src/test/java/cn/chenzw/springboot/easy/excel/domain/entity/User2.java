package cn.chenzw.springboot.easy.excel.domain.entity;

import com.alibaba.excel.annotation.format.DateTimeFormat;
import lombok.Data;

import java.util.Date;

@Data
public class User2 {
    private String name;

    @DateTimeFormat("yyyy-MM-dd")
    private Date birth;

    private Integer age;
}
