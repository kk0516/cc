package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication  //SpringBoot的主注解
@EnableEurekaServer     //EurEka的客户端
public class LeyouRegistryApplication {

    public static void main(String[] args){
        SpringApplication.run(LeyouRegistryApplication.class,args);
    }
}
