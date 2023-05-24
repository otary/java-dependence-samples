package cn.chenzw.dependence.rest.template.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("")
    public String index() {
        return "hello, zhangsan";
    }

    @PostMapping("")
    public String index2() {
        return "hello,lisi";
    }
}
