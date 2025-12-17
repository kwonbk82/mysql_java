package com.macademy.shop;

import org.springframework.web.bind.annotation.GetMapping;

public class HelloController {
    @GetMapping("/")
    public String main(){
        return "index";
    }
}
