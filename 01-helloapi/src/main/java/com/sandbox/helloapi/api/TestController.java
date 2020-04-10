package com.sandbox.helloapi.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Test")
public class TestController {

    @GetMapping(value = "/hello")
    public String Hello() {
        return "Hello World";
    }
}