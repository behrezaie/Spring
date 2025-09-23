package com.BehzadRezaei.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.BehzadRezaei.cruddemo.dao.StudentDAO;
import com.BehzadRezaei.cruddemo.entity.Student;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	// CommandLineRunner is a Spring Boot interface that indicates a bean should run when it is contained within a SpringApplication
	// It is used to execute code after the Spring Boot application has started
	// It is often used to perform initialization tasks or to run some code at startup
	// Here we are using it to test our DAO methods	
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// createStudent(studentDAO);

			// createMultipleStudents(studentDAO);

			// readStudent(studentDAO);

			// queryForStudents(studentDAO);

			// queryForStudentsByLastName(studentDAO, "smith");

			updateStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		// create a new student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Behzad", "Rezaei", "Behrezaie@gmail.com");

		// save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// print confirmation
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating multiple student objects ...");
		Student student1 = new Student("John", "Doe", "john.doe@gmail.com");
		Student student2 = new Student("Jane", "Smith", "jane.smith@gmail.com");
		Student student3 = new Student("Mike", "Brown", "mike.brown@gmail.com");

		System.out.println("Saving the students ...");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);

		System.out.println("Saved students. Generated ids: " +
			student1.getId() + ", " +
			student2.getId() + ", " +
			student3.getId());
	}

	private void readStudent(StudentDAO studentDAO) {
		// Retrieve a student by id (assuming id = 1 for demonstration)
		int theId = 4;
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		if (myStudent != null) {
			System.out.println("Found student: " + myStudent);
		} else {
			System.out.println("Student not found with id: " + theId);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		System.out.println("Querying for all students ...");
		List<Student> students = studentDAO.findAll();
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO, String lastName) {
		System.out.println("Querying for students with last name: " + lastName);
		List<Student> students = studentDAO.findByLastName(lastName);
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void updateStudent(StudentDAO studentDAO) {
		// Retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		// change the first name to "Scooby"
		System.out.println("Updating student ...");
		myStudent.setFirstName("Scooby");

		// update the student
		studentDAO.update(myStudent);

		// display the updated student
		System.out.println("Updated student: " + myStudent);
	}
}
