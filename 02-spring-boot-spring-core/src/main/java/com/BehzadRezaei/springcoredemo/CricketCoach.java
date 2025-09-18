package com.BehzadRezaei.springcoredemo;

import org.springframework.stereotype.Component;

// Component annotation registers this class as a Spring bean, 
// meaning that an instance of this class will be created and managed by the Spring container.
// How spring knows which implementation of Coach to inject?
// Because we have only one implementation of Coach interface (CricketCoach).
// If we had multiple implementations, we would need to use @Qualifier annotation to specify which one to use.
@Component
public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes!";
    }

}
