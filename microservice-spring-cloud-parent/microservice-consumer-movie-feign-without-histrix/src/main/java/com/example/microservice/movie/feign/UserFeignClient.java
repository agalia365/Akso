package com.example.microservice.movie.feign;

import com.example.microservice.movie.feign.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "microservice-provider-user2",  fallback = FeignClientFallback.class)
public interface UserFeignClient {
    @RequestMapping(value = "/simple/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable("id") Long id );

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User postUser(User user);

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User getUser(User user);
}
