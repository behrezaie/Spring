package com.BehzadRezaei.springboot.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

@RestController
public class FunRestController {

    // Injecting values from application.properties
    @Value("${country.name}")
    private String countryName;
    
    @Value("${country.province}")
    private String countryProvince;

    // expose new endpoint for "/country"
    @GetMapping("/country")
    public String getCountryInfo() {
        return "Country: " + countryName + ", Province: " + countryProvince;
    }

    // expose "/" that returns "Hello World"
    @GetMapping("/")
    public String sayHello() {
        return "Hello World!";
    }

    // expose a new endpoint for "workout"
    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a hard 5k!";
    }

    // expose a new endpoint for "fortune"
    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "Today is your lucky day!";
    }
}
