package com.akso.spring.cloud.ribbon.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

@Configuration
@RibbonClient(name="")
public class TestConfiguration {
}
