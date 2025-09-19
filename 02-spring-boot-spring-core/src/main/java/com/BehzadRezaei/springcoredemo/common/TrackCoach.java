package com.BehzadRezaei.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
// Lazy annotation tells Spring to create the bean only when it is requested for the first time.
// This can help to improve startup time and reduce memory usage if the bean is not always needed.
// By default, Spring creates all singleton beans at startup time (eager initialization).
// If we want to change this bavahior for all beans, we can set the following property in application.properties file:
// spring.main.lazy-initialization=true
@Lazy
public class TrackCoach implements Coach {

    public TrackCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k!";
    }

}
