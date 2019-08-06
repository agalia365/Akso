package com.akso.spring.config;

import com.akso.spring.bean.Person;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

@ComponentScan("com.akso.spring.bean")
@Configuration
public class MainConfigOfProfile {

    @Bean
    @Profile("dev")
    public DataSource dataSourceDev() {

        return null;
    }

    @Profile("test")
    public DataSource dataSourceTest() {

        return null;
    }

    @Profile("prod")
    public DataSource dataSourceProd() {

        return null;
    }
}
