package cn.chenzw.java.dependence.cxf.service.impl;

import cn.chenzw.java.dependence.cxf.service.WeatherService;
import org.springframework.stereotype.Component;

import javax.jws.WebService;

//@WebService(serviceName = "WeatherService", targetNamespace = "http://demo.example.com/")
@Component
public class WeatherServiceImpl implements WeatherService {

    @Override
    public String getTodayWeather(String tag) {
        return "good!";
    }
}
