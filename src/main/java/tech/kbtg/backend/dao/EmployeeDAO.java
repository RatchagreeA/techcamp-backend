package tech.kbtg.backend.dao;

import tech.kbtg.backend.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    Employee save(Employee employee);

    Employee findById(Integer id);

    Employee deleteById(Integer id);

    List<Employee> findAll();
    List<Employee> findByName(String q);
}
