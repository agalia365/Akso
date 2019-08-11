package com.example.microservice.movie.feign.entity;

import com.example.microservice.movie.feign.FeignClientFallback;
import com.example.microservice.movie.feign.config.FeignDisableHystrixConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "microservice-provider-user2",  fallback = FeignClientFallback2.class, configuration = FeignDisableHystrixConfiguration.class)
public interface UserFeignClient2 {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String getUser();
}
