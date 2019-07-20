package com.example.childhello01.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        String s = LocalTime.now().toString();
        return s + "\t--->\thello";
    }
}
