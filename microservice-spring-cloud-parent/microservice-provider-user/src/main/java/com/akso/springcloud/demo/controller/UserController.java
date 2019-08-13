package com.akso.springcloud.demo.controller;

import com.akso.springcloud.demo.entity.User;
import com.akso.springcloud.demo.service.UserService;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    public EurekaClient eurekaClient;

    @GetMapping("/simple/{id}")
    public User findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("/eureka-instance")
    public String serviceUrl() {
        InstanceInfo instance = eurekaClient.getNextServerFromEureka("localhost", true);
        return instance.getHomePageUrl();
    }

    @PostMapping(value = "/user")
    public User postUser(@RequestBody User user) {
        return user;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String getUser() {
        return "hello test";
    }
}
