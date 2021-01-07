package cn.chenzw.java.dependence.jaxb.domain;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement
public class User {

    private Long id;

    private String name;
}
