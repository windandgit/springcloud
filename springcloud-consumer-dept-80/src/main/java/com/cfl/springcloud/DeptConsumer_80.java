package com.cfl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * ①、此处的@EnableDiscoveryClient和 @EnableEurekaClient的功能是相同的，都是服务发现，但是据说是前者适合所有的负载均衡，后者只适合eureka
 * ②、ribbon和eureka整合以后，客户端可以直接调用，不用关系ip地址和端口号
 */
@SpringBootApplication
@EnableDiscoveryClient
//@EnableEurekaClient
public class DeptConsumer_80 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_80.class,args);
    }
}
