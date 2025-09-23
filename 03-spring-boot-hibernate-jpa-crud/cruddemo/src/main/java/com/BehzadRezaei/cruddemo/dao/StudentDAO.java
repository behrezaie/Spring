package com.BehzadRezaei.cruddemo.dao;
import com.BehzadRezaei.cruddemo.entity.Student;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(int theId);
}
