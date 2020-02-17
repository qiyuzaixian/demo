package com.config;

import org.springframework.stereotype.Controller;

@Controller
public class IndexController {
    public String index(){
        System.out.println("index");
        return "index";
    }
}
