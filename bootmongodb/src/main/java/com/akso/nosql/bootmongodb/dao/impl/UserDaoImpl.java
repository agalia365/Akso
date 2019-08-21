package com.akso.nosql.bootmongodb.dao.impl;

import com.akso.nosql.bootmongodb.dao.UserDao;
import com.akso.nosql.bootmongodb.model.ResultObject;
import com.akso.nosql.bootmongodb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class UserDaoImpl implements UserDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public ResultObject insertUser(User user) {
        this.mongoTemplate.insert(user);
        return new ResultObject("0", null);
    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public List<User> findAll() {
        Query query = new Query();
       return mongoTemplate.find(query, User.class);

    }

    @Override
    public User getUser(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        User user = mongoTemplate.find(query, User.class).get(0);

//        User user = new User();
//        user.setId(id);
        return user;
    }
}
