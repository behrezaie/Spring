package com.BehzadRezaei.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BehzadRezaei.springboot.cruddemo.dao.EmployeeDAO;
import com.BehzadRezaei.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
            employeeDAO = theEmployeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        // TODO Auto-generated method stub
        return employeeDAO.findAll();
    }

}
