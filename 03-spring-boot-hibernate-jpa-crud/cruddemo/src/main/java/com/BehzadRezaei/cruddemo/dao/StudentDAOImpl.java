package com.BehzadRezaei.cruddemo.dao;
import com.BehzadRezaei.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
// Repository is a Spring annotation that indicates that the class is a DAO component
// It is a specialization of @Component annotation
// It is used to indicate that the class is a Data Access Object
// It is also used to translate database exceptions into Spring's DataAccessException
// So that we can handle them in a consistent way
public class StudentDAOImpl implements StudentDAO {

    // define field for entity manager
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    // Autowired means Spring will inject the dependency
    // here the dependency is EntityManager
    // EntityManager is used to interact with the database
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    // Transactional annotation is required for save, update, delete operations
    // because these operations change the database
    public void save(Student theStudent) {
        // save student
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(int theId) {
        // get student
        Student theStudent = entityManager.find(Student.class, theId);
        return theStudent;
    }
}
