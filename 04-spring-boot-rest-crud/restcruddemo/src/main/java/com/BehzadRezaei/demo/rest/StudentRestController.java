package com.BehzadRezaei.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.BehzadRezaei.demo.entity.Student;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    // define endpoint for "/students" - return list of students
    @GetMapping("/students")
    public List<Student> getStudents() {

        // create list of students
        List<Student> theStudents = new ArrayList<>();

        theStudents.add(new Student("Pooya", "Rezaei"));
        theStudents.add(new Student("Sara", "Rezaei"));
        theStudents.add(new Student("Ali", "Rezaei"));

        return theStudents;
    }
}
