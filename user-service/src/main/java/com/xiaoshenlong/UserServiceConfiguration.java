package com.xiaoshenlong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "com.xiaoshenlong.dao")
public class UserServiceConfiguration {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceConfiguration.class);
    }
}
