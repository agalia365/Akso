package com.akso.nosql.bootmongodb.dao;

import com.akso.nosql.bootmongodb.model.ResultObject;
import com.akso.nosql.bootmongodb.model.User;

import java.util.List;

public interface UserDao {
    public User getUser(String id);

    public List<User> findAll();

    public ResultObject insertUser(User user);

    public void deleteUser(User user);

    public User updateUser(User user);
}
