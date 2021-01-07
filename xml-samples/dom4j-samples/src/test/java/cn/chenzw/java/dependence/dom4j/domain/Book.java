package cn.chenzw.java.dependence.dom4j.domain;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Book {

    //书的id
    private int id;

    //书名
    private String name;

    //书的作者
    private String author;

    //书的出版年份
    private int year;

    //书的售价
    private double price;

    //书的语言
    private String language;
}
