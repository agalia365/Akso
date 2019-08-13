package com.example.microservice.movie.feign;

import com.example.microservice.movie.feign.entity.User;
import org.springframework.stereotype.Component;

@Component
public class FeignClientFallback implements UserFeignClient {
    @Override
    public User findById(Long id) {
        User user = new User();
        user.setId(0L);
        user.setUsername("default user");
        return user;
    }

    @Override
    public User postUser(User user) {
        return null;
    }

    @Override
    public User getUser(User user) {
        return null;
    }
}
