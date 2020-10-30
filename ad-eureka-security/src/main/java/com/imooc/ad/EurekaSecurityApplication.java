package com.imooc.ad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 安全校验的eureka
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaSecurityApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaSecurityApplication.class,args);

    }
}
