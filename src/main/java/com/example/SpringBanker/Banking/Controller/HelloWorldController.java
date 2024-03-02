package com.example.SpringBanker.Banking.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello";
    }
}
