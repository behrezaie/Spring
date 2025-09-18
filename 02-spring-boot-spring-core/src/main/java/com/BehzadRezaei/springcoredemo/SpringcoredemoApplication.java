package com.BehzadRezaei.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// By default, Spring Boot scans for components (like @Component, @Service, @Repository, @Controller)
// in the package where the main application class is located and its sub-packages.
// Since our main application class is in "com.BehzadRezaei.springcoredemo" package,
// we need to specify the base packages to scan using scanBasePackages attribute
// to include "com.BehzadRezaei.util" package where our CricketCoach class is located.
// @SpringBootApplication(scanBasePackages = {"com.BehzadRezaei.util", "com.BehzadRezaei.springcoredemo"})
@SpringBootApplication
public class SpringcoredemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcoredemoApplication.class, args);
	}

}
