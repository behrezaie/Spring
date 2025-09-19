package com.BehzadRezaei.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// Component annotation registers this class as a Spring bean, 
// meaning that an instance of this class will be created and managed by the Spring container.
// How spring knows which implementation of Coach to inject?
// Because we have only one implementation of Coach interface (CricketCoach).
// If we had multiple implementations, we would need to use @Qualifier annotation to specify which one to use.
@Component
// Primary annotation tells Spring to use this bean when there are multiple beans of the same type.
// However, in this case, we are using @Qualifier in the controller to specify which bean to use.
// and Qualifier has higher priority than Primary. therefore, since we have used both, Spring will use the bean specified in Qualifier.
// We can't have multiple beans with @Primary annotation.
@Primary
public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes!";
    }

}
