package tech.kbtg.backend.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import tech.kbtg.backend.dao.EmployeeDAO;
import tech.kbtg.backend.entity.Employee;
import tech.kbtg.backend.exception.NotFoundException;
import tech.kbtg.backend.repository.EmployeeRepository;
import tech.kbtg.backend.service.EmployeeService;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private EmployeeDAO employeeDAO;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeDAO employeeDAO) {
        this.employeeRepository = employeeRepository;
        this.employeeDAO = employeeDAO;
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee findById(Integer id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (!employee.isPresent()){
            throw new NotFoundException("Not found employee ID: "+id);
        }
        return employee.get();
    }

    @Override
    @Transactional
    public Employee deleteById(Integer id) {
        Employee employee = findById(id);
        employeeRepository.deleteById(id);
        return employee;
    }

    @Override
    public List<Employee> findAll() {
//        Optional<Employee> b2 = employeeRepository.findByLastName("b2");
//        System.out.println(b2);
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> findByName(String q) {

//        return employeeRepository.findByFirstnameContains(q);
        return employeeDAO.findByName(q);
    }

    @Override
    public Employee getById(Integer id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (!employee.isPresent()){
            return null;
        }
        return employee.get();
    }

}
