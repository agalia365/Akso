package com.example.microservice.movie.feign.controller;

import com.example.microservice.movie.feign.UserFeignClient;
import com.example.microservice.movie.feign.entity.User;
import com.example.microservice.movie.feign.entity.UserFeignClient2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieController2 {

    @Autowired
    private UserFeignClient userFeignClient;

    @Autowired
    private UserFeignClient2 userFeignClient2;


    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id ) {
        return userFeignClient.findById(id);
    }

    @GetMapping("/test")
    public User testPost(User user) {
        return userFeignClient.postUser(user);
    }

    @GetMapping("/test-get")
    public User testGet(User user) {
        return userFeignClient.getUser(user);
    }

    @RequestMapping(value = "/test22", method = RequestMethod.GET)
    public String getUser() {
        return userFeignClient2.getUser();
    }
}
