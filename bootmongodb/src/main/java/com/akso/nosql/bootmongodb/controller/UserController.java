package com.akso.nosql.bootmongodb.controller;

import com.akso.nosql.bootmongodb.model.ResultObject;
import com.akso.nosql.bootmongodb.model.User;
import com.akso.nosql.bootmongodb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService serService;


    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable String id) {
        return serService.getUser(id);
    }

    @GetMapping(value = "/inserUsers/{id}")
    public ResultObject insertUser(@PathVariable String id) {
        User user = new User();
        user.setId(id);
        return serService.insertUser(user);
    }

    @GetMapping(value = "/findall")
    public List<User> findall() {
        return serService.findAll();
    }


}
