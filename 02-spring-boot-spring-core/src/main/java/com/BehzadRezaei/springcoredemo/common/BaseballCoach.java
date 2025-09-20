package com.BehzadRezaei.springcoredemo.common;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;

@Component
// Singleton scope means only one instance of the bean will be created and shared across the application.
// This is the default scope.
// Prototype scope means a new instance of the bean will be created each time it is requested from the Spring container.
// We can use prototype scope to demonstrate that two different instances of the same bean are created.
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // define the scope of the bean, default is singleton
public class BaseballCoach implements Coach {

    public BaseballCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes on batting practice.";
    }

}
