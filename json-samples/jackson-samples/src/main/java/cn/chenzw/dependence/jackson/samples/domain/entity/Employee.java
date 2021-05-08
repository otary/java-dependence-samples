package cn.chenzw.dependence.jackson.samples.domain.entity;

import lombok.Data;

import java.util.List;

@Data
public class Employee {

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private int age;

    /**
     * 职务
     */
    private String designation;

    /**
     * 薪水
     */
    private double salary;


    /**
     * 多个住址
     */
    private List<Address> address;
}
