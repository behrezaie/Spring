package com.BehzadRezaei.springcoredemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BehzadRezaei.springcoredemo.common.Coach;

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

    // define a setter method for dependency injection
    @Autowired
    public void setMyCoach(Coach theCoach) {
        this.myCoach = theCoach;
    }

    // expose a REST endpoint
    @GetMapping("/dailyworkout")
    public String dailyWorkout() {
        return myCoach.getDailyWorkout();
    }

}
