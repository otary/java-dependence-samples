package cn.chenzw.java.dependence.cxf.config;

import cn.chenzw.java.dependence.cxf.service.WeatherService;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class WsConfig {

    @Autowired
    private Bus bus;

    @Autowired
    WeatherService weatherService;


    @Bean
    public ServletRegistrationBean wsDispatcherServlet() {
        return new ServletRegistrationBean(new CXFServlet(), "/webService/*");
    }


    /**
     * 访问：http://localhost:8080/webService/weather?wsdl
     * @return
     */
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, weatherService);
        endpoint.publish("/weather");
        return endpoint;
    }

}
