package com.xiaoshenlong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerConfiguration {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerConfiguration.class);
    }

}
