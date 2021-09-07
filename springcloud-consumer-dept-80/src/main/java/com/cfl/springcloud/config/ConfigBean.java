package com.cfl.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

    //配置负载均衡的RestTemplate
    @Bean
    @LoadBalanced  //负载均衡注解
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
