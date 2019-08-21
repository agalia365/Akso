package com.example.microservice.movie.feign.controller;

import com.example.microservice.movie.feign.UserFeignClient;
import com.example.microservice.movie.feign.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieController2 {

    @Autowired
    private UserFeignClient userFeignClient;


    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id) {
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
}
