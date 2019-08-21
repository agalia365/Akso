package com.akso.nosql.bootmongodb.service;

import com.akso.nosql.bootmongodb.dao.UserDao;
import com.akso.nosql.bootmongodb.model.ResultObject;
import com.akso.nosql.bootmongodb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User getUser(String id) {
        return userDao.getUser(id);
    }

    public ResultObject insertUser(User user) {
        return userDao.insertUser(user);
    }

    public List<User> findAll() {
        return userDao.findAll();

    }


}
