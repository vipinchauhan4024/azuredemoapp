package com.hackathon.demoapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController  
@RequestMapping("api/v1/")
public class GreetingController {

    @ApiOperation(value = "greetings")
    @GetMapping(path = "greeting")
    public String getGreeting()   
    {  
     return "Hello Azure demo app Service is running Ok!! " ;
    }  
}

