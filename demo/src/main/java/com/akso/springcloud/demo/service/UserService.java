package com.akso.springcloud.demo.service;

import com.akso.springcloud.demo.dao.UserRepository;
import com.akso.springcloud.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findById(Long id) {
        Optional<User> one = userRepository.findById(id);
        return one.get();
     }
}
