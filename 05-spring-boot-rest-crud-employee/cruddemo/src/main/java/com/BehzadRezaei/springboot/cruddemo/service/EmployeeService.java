package com.BehzadRezaei.springboot.cruddemo.service;

import java.util.List;

import com.BehzadRezaei.springboot.cruddemo.entity.Employee;

public interface EmployeeService {

        List<Employee> findAll();
}
