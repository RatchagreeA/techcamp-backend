package tech.kbtg.backend.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import tech.kbtg.backend.dao.EmployeeDAO;
import tech.kbtg.backend.entity.Employee;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private EntityManager entityManager;

    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Employee save(Employee employee) {
        return entityManager.merge(employee);
    }


    @Override
    public Employee findById(Integer id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public Employee deleteById(Integer id) {
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.remove(employee);
        return employee;
    }
    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee", Employee.class);
        List<Employee> employees = theQuery.getResultList();
        return employees;
    }

    @Override
    public List<Employee> findByName(String q) {
        String s = "FROM Employee WHERE firstname LIKE '%"+q+"%' OR lastname LIKE '%"+q+"%'";
        System.out.println(s);
        TypedQuery<Employee> theQuery = entityManager.createQuery(s, Employee.class);
        List<Employee> employees = theQuery.getResultList();
        return employees;
    }
}
