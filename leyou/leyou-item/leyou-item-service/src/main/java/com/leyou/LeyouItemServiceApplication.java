package com.leyou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication   //SpringBoot的主注解
@EnableDiscoveryClient    //EurEka的客户端
public class LeyouItemServiceApplication {

    public static void main(String[] args){
        SpringApplication.run(LeyouItemServiceApplication.class,args);
    }
}
