package com.example.ymsdemo.feignclient;

import com.netflix.config.ConfigurationManager;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.ribbon.RibbonClient;
import org.jsoup.helper.StringUtil;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * Feign客户端，作为微服务调用客户端，配置读取
 * 支持负载均衡
 */
@Component
public class FeignClient {
    /**
     * 初始化,读取配置文件
     */
    @PostConstruct
    public void initMethod(){
        try {
            ConfigurationManager.loadPropertiesFromResources("feign.properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *  获取代理服务并配置数据
     * @param serviceClass  代理的服务类
     * @param serviceId     代理的服务名称，feign.properties配置文件中配置
     * @param contextPath   应用路径
     * @param <T>           返回类型
     * @return
     * @throws IOException
     */
    public <T extends Object> T getProxyService(Class<T> serviceClass,String serviceId , String contextPath) throws IOException {
        if(StringUtil.isBlank(serviceId)){
            throw new RuntimeException();
        }
        /**
         *
         */
        StringBuilder serviceUrl = new StringBuilder();
        serviceUrl.append("http://");
        serviceUrl.append(serviceId);
        serviceUrl.append("/");
        if(!StringUtil.isBlank(contextPath)){
            serviceUrl.append(contextPath);
        }
        T service = Feign.builder().client(RibbonClient.create()).encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder()).target(serviceClass, serviceUrl.toString());
        return service;
    }


}
