package tech.kbtg.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.kbtg.backend.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Optional<Employee> findByLastname(String lastname);
    List<Employee> findByFirstnameContains(String q);

}
