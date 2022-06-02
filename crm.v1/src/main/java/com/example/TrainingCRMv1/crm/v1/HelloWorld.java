package com.example.TrainingCRMv1.crm.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
    @GetMapping("/hello")
    @PostMapping
    public String hello(){
        return "Hello world!";
    }
}