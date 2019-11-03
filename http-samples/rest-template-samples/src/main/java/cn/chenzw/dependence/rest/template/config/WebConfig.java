package cn.chenzw.dependence.rest.template.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"cn.chenzw.dependence.rest.template"})
public class WebConfig {
}
