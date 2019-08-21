package com.akso.nosql.bootmongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class BootmongodbApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(BootmongodbApplication.class, args);
    }

    @Override
    public SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(BootmongodbApplication.class);
    }
}
