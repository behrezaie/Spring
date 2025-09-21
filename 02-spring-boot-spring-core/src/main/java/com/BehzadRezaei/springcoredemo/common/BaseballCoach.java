package com.BehzadRezaei.springcoredemo.common;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

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

    // define out init method
    // PostConstruct is called after the bean is constructed and dependencies are injected
    // It's a good place to put any initialization code
    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println("In doMyStartupStuff(): " + getClass().getSimpleName());
    }
    // define our destroy method
    // PreDestroy is called before the bean is destroyed
    // It's a good place to put any cleanup code
    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println("In doMyCleanupStuff(): " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes on batting practice.";
    }

}

// Prototype Beans and Destroy Lifecycle
// There is a subtle point you need to be aware of with "prototype" scoped beans.

// For "prototype" scoped beans, Spring does not call the destroy method. Gasp!

// ---

// In contrast to the other scopes, Spring does not manage the complete lifecycle of a 
// prototype bean: the container instantiates, configures, and otherwise assembles a prototype object,
// and hands it to the client, with no further record of that prototype instance.

// Thus, although initialization lifecycle callback methods are called on all objects regardless 
// of scope, in the case of prototypes, configured destruction lifecycle callbacks are not called. 
// The client code must clean up prototype-scoped objects and release expensive resources that the 
// prototype bean(s) are holding.

