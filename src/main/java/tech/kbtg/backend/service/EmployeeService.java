package tech.kbtg.backend.service;

import tech.kbtg.backend.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee save(Employee employee);
    Employee findById(Integer id);
    Employee deleteById(Integer id);
    List<Employee> findAll();
    List<Employee> findByName(String q);
    Employee getById(Integer id);
}
