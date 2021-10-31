package com.example.springbootdockerization;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloDockerApi {

    @GetMapping
    public String sayHello(){
        return "Docker: Hello Spring Boot";
    }

}
