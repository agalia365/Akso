package com.akso.nosql.bootmongodb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SystemController {

    @RequestMapping(value="/index")
    public String index() {
        return "views/index";
    }
}
