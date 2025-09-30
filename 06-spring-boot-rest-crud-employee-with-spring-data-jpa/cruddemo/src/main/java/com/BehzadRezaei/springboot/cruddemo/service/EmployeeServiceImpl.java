package com.BehzadRezaei.springboot.cruddemo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.BehzadRezaei.springboot.cruddemo.dao.EmployeeDAO;
import com.BehzadRezaei.springboot.cruddemo.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
            employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        // TODO Auto-generated method stub
        return employeeRepository.findAll();
    }
    
    @Override
    public Employee findById(int theId) {
        // TODO Auto-generated method stub
        return employeeRepository.findById(theId);
    }
    
    @Override
    public Employee save(Employee theEmployee) {    
        // TODO Auto-generated method stub
        return employeeRepository.save(theEmployee);
    }
    
    @Override
    public void deleteById(int theId) {
        // TODO Auto-generated method stub
        employeeRepository.deleteById(theId);
    }

}
