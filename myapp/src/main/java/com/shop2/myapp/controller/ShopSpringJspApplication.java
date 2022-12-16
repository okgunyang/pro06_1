package com.shop2.myapp.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ShopSpringJspApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ShopSpringJspApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ShopSpringJspApplication.class);
    }

}
