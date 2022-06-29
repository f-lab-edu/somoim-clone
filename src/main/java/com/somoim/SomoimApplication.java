package com.somoim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class SomoimApplication {

    public static void main(String[] args) {
        SpringApplication.run(SomoimApplication.class, args);
    }
}
