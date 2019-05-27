package com.qj.springbatchdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.qj.**")
public class SpringbatchDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbatchDemoApplication.class, args);
    }

}
