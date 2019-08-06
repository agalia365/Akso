package com.akso.springcloud.demo.controller;

import com.akso.springcloud.demo.entity.User;
import com.akso.springcloud.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/simple/{id}")
    public User findById(@PathVariable Long id) {
        return userService.findById(id);
    }

}
