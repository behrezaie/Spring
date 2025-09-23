package com.BehzadRezaei.cruddemo.dao;
import java.util.List;
import com.BehzadRezaei.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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

    @Override
    public List<Student> findAll() {
        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName", Student.class);

        // return query results
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        // create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);
        theQuery.setParameter("theData", theLastName);
        // return query results
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        // update student
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(int theId) {
        // retrieve the student
        Student theStudent = entityManager.find(Student.class, theId);

        // delete student by id
        if (theStudent != null) {
            entityManager.remove(theStudent);
        }
    }

    @Override
    @Transactional
    public int deleteAll() {
        // delete all students
        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numRowsDeleted;
    }
}
