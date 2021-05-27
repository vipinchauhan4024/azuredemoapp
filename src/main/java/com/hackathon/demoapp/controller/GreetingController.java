package com.hackathon.demoapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  
@RequestMapping("api/")
public class GreetingController {

    @GetMapping(path = "greeting")
    public String getGreeting()   
    {  
     return "Hello Azure demo app Service is running Ok!! " ;
    }  
}

