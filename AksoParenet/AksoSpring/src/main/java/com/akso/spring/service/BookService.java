package com.akso.spring.service;

import com.akso.spring.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Autowired spring  定义的自动导包
 * @Inject[JSR330] @Resource[JSR250] 都是java 的规范
 * @Autowired ： 构造器， 参数， 方法， 属性
 * 1. 标注在方法位置
 */
@Service
public class BookService {

    @Autowired
    private BookDao bookDao;

    public BookDao getBookDao() {
        return bookDao;
    }

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }
}
