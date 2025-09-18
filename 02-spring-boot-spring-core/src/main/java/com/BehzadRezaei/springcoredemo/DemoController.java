package com.BehzadRezaei.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define a private field for the dependency
    private Coach myCoach;

    // define a constructor for dependency injection
    // Autowired annotation tells Spring to inject the dependency here.
    // We can use constructor injection, setter injection, or field injection.
    // How does Spring know which implementation of Coach to inject?
    // Because we have only one implementation of Coach interface (CricketCoach).
    @Autowired
    public DemoController(Coach theCoach) {
        myCoach = theCoach;
    }

    // expose a REST endpoint
    @GetMapping("/dailyworkout")
    public String dailyWorkout() {
        return myCoach.getDailyWorkout();
    }

}
