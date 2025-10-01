package com.BehzadRezaei.springboot.cruddemo.dao;

import com.BehzadRezaei.springboot.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

// By default, Spring Data JPA will create a bean with the name employeeRepository
// that implements this interface and provides the CRUD operations
// for the Employee entity class
// And for the rest endpoints, Spring Data REST will automatically create the endpoints
// based on the methods provided by JpaRepository interface
// For example, GET /employees, GET /employees/{id}, POST /employees, PUT /employees/{id}, DELETE /employees/{id}
// It simply uses the entity class name (Employee) and converts it to lowercase and pluralizes it (employees)
// But what if we want to change the base path of the endpoints?
// We can do that by adding the @RepositoryRestResource annotation to this interface
// Like this:
// @RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that's it ... no need to write any code LOL!

}
