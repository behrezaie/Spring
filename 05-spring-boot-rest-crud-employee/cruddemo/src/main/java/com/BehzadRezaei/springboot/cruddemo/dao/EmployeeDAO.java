package com.BehzadRezaei.springboot.cruddemo.dao;

import java.util.List;

import com.BehzadRezaei.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {

    List<Employee> findAll();

}
