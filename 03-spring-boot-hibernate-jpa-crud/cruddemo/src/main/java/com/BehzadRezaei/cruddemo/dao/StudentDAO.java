package com.BehzadRezaei.cruddemo.dao;
import java.util.List;

import com.BehzadRezaei.cruddemo.entity.Student;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(int theId);

    List<Student> findAll();

    List<Student> findByLastName(String theLastName);

    void update(Student theStudent);

    void delete(int theId);

    int deleteAll();
}
