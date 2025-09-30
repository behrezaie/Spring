package main.java.com.BehzadRezaei.springboot.cruddemo.dao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaReposiory<Employee, Integer> {

    // that's it ... no need to write any code LOL!

}
