package com.BehzadRezaei.springboot.cruddemo.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.BehzadRezaei.springboot.cruddemo.entity.Employee;
import com.BehzadRezaei.springboot.cruddemo.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    private ObjectMapper objectMapper = new ObjectMapper();
    
    // inject employee dao
    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService, ObjectMapper theObjectMapper) {
        employeeService = theEmployeeService;
        objectMapper = theObjectMapper;
    }
    
    // expose "/employees" and return list of employees
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    // add mapping for GET /employees/{employeeId}
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {

        Employee theEmployee = employeeService.findById(employeeId);

        if (theEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        return theEmployee;
    }

    // add mapping for POST /employees - add new employee
    @PostMapping("/employees")
    // @RequestBody means that we expect the employee data to come in
    // as JSON in the body of the request
    public Employee addEmployee(@RequestBody Employee theEmployee) {
        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update

        theEmployee.setId(0);

        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    // add mapping for PATCH /employees/{employeeID} - partial update of an employee

    @PatchMapping("/employees/{employeeId}")
    public Employee patchEmployee(@PathVariable int employeeId, @RequestBody Map<String, Object> patchPayload) {
        Employee dbEmployee = employeeService.findById(employeeId);
        if (dbEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }
        if (patchPayload.containsKey("id")) {
            throw new RuntimeException("Employee id not allowed in the request body - " + employeeId);
        }
        Employee patchedEmployee = apply(patchPayload, dbEmployee);
        Employee savedEmployee = employeeService.save(patchedEmployee);
        return savedEmployee;
    }

    // Helper method to apply patchPayload to dbEmployee
    private Employee apply(Map<String, Object> patchPayload, Employee dbEmployee) {
        // Use ObjectMapper to update dbEmployee with patchPayload
        ObjectNode employeeNode = objectMapper.convertValue(dbEmployee, ObjectNode.class);
        // convert patchPayload to ObjectNode
        ObjectNode patchNode = objectMapper.convertValue(patchPayload, ObjectNode.class);
        employeeNode.setAll(patchNode);

        return objectMapper.convertValue(employeeNode, Employee.class);
    }

    // add mapping for DELETE /employees/{employeeId} - delete an employee
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        Employee tempEmployee = employeeService.findById(employeeId);

        // throw exception if null
        if (tempEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        employeeService.deleteById(employeeId);

        return "Deleted employee id - " + employeeId;
    }

}
