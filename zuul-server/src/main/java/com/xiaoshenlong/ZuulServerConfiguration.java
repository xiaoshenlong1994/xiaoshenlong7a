package com.xiaoshenlong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ZuulServerConfiguration {

    public static void main(String[] args) {
        SpringApplication.run(ZuulServerConfiguration.class);
    }

}
