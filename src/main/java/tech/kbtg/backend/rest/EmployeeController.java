package tech.kbtg.backend.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.kbtg.backend.entity.Employee;
import tech.kbtg.backend.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("")
    public List<Employee> getEmployee() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeService.findById(id);
    }

    @PostMapping("")
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setStatus("current");
        return employeeService.save(employee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable int id) {
        Employee employee = employeeService.findById(id);
        employee.setStatus("deleted");
        employeeService.save(employee);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No Content");
    }

    @PutMapping("")
    public Employee updateEmployee(@RequestBody Employee employee) {
        Employee emp = employeeService.findById(employee.getId());
        emp.setFirstname(employee.getFirstname());
        emp.setLastname(employee.getLastname());
        emp.setNickname(employee.getNickname());
        emp.setAddress(employee.getAddress());
        return employeeService.save(emp);
    }

    @PutMapping("/salary/{id}")
    public Employee updateSalaryById(@PathVariable int id,
                                     @RequestParam(defaultValue = "0") Integer p) {
        p = Math.min(p, 100);
        p = Math.max(p, 0);
        Employee emp = employeeService.findById(id);
        Integer salary = emp.getSalary();
        salary = salary + (salary * p / 100);
        emp.setSalary(salary);
        return employeeService.save(emp);
    }

    @PutMapping("/position/{id}")
    public ResponseEntity<?> updatePositionById(@PathVariable int id,
                                                @RequestParam(defaultValue = "") String oldPos,
                                                @RequestParam(defaultValue = "") String newPos
    ) {
        Employee emp = employeeService.findById(id);
        if (!oldPos.equals(emp.getPosition())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Current position is incorrect");
        }
        emp.setPosition(newPos);
        employeeService.save(emp);
        return ResponseEntity.status(HttpStatus.CREATED).body("Updated");
    }

    @GetMapping("/name")
    public List<Employee> getEmployeeByName(@RequestParam(defaultValue = "") String q) {
        return employeeService.findByName(q);
    }

    @DeleteMapping("")
    public ResponseEntity<?> deleteEmployees(@RequestBody List<Employee> employees) {
        List<Integer> nf = new ArrayList<>();
        for (Employee emp : employees) {
            Employee eDB = employeeService.getById(emp.getId());
            if (eDB != null) {
                eDB.setStatus("deleted");
                employeeService.save(eDB);
            } else {
                nf.add(emp.getId());
            }
        }
        if (nf.size() > 0) {
            return ResponseEntity.status(HttpStatus.MULTI_STATUS).body("not_found_ids: "+nf.toString());
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No Content");
    }
}
