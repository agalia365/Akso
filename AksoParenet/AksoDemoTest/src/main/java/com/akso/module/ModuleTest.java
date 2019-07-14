package com.akso.module;

import com.akso.java9.bean.Person;
import com.akso.java9.entity.User;
import org.junit.Test;

public class ModuleTest {
    public static void main(String[] args) {
        Person p = new Person("Tom", 12);
        System.out.println(p);

        User user = new User("Test", 20);
        System.out.println(user);
    }

    @Test
    public void test() {

    }
}
