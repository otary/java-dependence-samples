package cn.chenzw.springboot.easy.excel.domain.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import lombok.Data;

import java.util.Date;

@Data
public class User {

    @ExcelProperty("姓名")
    private String name;

    @DateTimeFormat("yyyy-MM-dd")
    @ExcelProperty("生日")
    private Date birth;

    @ExcelProperty("年齡")
    private Integer age;

}
