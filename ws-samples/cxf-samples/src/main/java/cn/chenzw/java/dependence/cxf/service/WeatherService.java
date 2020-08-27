package cn.chenzw.java.dependence.cxf.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface WeatherService {

    @WebMethod
    String getTodayWeather(@WebParam(name = "tag") String tag);
}
