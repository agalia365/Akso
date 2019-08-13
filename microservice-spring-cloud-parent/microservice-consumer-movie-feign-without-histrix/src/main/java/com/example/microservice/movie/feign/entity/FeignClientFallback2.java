package com.example.microservice.movie.feign.entity;

import com.example.microservice.movie.feign.UserFeignClient;
import org.springframework.stereotype.Component;

@Component
public class FeignClientFallback2 implements UserFeignClient2 {
    @Override
    public String getUser() {
        return "Heelo hystrix";
    }
}
