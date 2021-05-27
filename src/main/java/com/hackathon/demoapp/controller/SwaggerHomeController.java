package com.hackathon.demoapp.controller;

import java.net.URI;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SwaggerHomeController {

    @GetMapping(value = "/")
    public ResponseEntity<Void> index() {
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("swagger-ui.html"));
        return new ResponseEntity<>(headers, HttpStatus.FOUND);
    }
}