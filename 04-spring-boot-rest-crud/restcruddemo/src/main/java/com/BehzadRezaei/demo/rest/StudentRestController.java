package com.BehzadRezaei.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.BehzadRezaei.demo.entity.Student;

import jakarta.annotation.PostConstruct;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    // define @PostConstruct to load the student data ... only once!
    // @PostConstruct is used to run the method once after the bean is created
    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();

        theStudents.add(new Student("Pooya", "Rezaei"));
        theStudents.add(new Student("Sara", "Rezaei"));
        theStudents.add(new Student("Ali", "Rezaei"));
    }

    // define endpoint for "/students" - return list of students
    @GetMapping("/students")
    public List<Student> getStudents() {

        return theStudents;
    }

    // define endpoint for "/students/{studentId}" - return student at index
    @GetMapping("/students/{studentId}")
    // @PathVariable is used to extract the value from the URL
    // and assign it to the method parameter
    // e.g. /students/1 -> studentId = 1
    public Student getStudent(@PathVariable int studentId) {

        // check the studentId against list size
        if ((studentId >= theStudents.size()) || (studentId < 0)) {
            throw new RuntimeException("Student id not found - " + studentId);
        }

        return theStudents.get(studentId);
    }
}
