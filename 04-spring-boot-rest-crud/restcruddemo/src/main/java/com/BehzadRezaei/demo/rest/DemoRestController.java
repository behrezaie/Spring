package com.BehzadRezaei.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
// RequestMapping is used to define a base URL for all endpoints in this controller
// While GetMapping is used to define a specific endpoint for HTTP GET requests
// So, basically GetMapping is a specialized version of RequestMapping for GET requests
// and is equal to @RequestMapping(method = RequestMethod.GET)
public class DemoRestController {

    // exposing "/hello" endpoint that returns "Hello World!"
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World!";
    }
}
