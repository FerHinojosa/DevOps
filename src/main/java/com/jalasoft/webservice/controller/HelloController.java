package com.jalasoft.webservice.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
@RequestMapping ("/api/v1.0/hello")
public class HelloController {

    @GetMapping
    public String SayHello(){
        return "HelloGet";
    }
    @PutMapping
    public String PutHello(){
        return "HelloPut";
    }
    @PostMapping
    public String PostHello(){ return "HelloPost"; }
    @DeleteMapping
    public String DeleteHello(){ return "HelloDelete"; }
}

