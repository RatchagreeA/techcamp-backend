package tech.kbtg.backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tech.kbtg.backend.entity.Employee;
import tech.kbtg.backend.service.EmployeeService;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(EmployeeService employeeService){
		return runner -> {
			initData(employeeService);
		};
	}

	private void initData(EmployeeService employeeService) {
		Employee employee1 = new Employee("f1", "l1", "n1", 1000, "current", "address1", "p1");
		Employee employee2= new Employee("f2", "l2", "n2", 2000, "current", "address2", "p2");
		Employee employee3 = new Employee("f3", "l3", "n3", 3000, "current", "address3", "p3");
		Employee employee4 = new Employee("f4", "l4t", "n4", 4000, "current", "address4", "p4");
		Employee employee5 = new Employee("f5t", "l5", "n5", 5000, "current", "address5", "p5");


		employeeService.save(employee1);
		employeeService.save(employee2);
		employeeService.save(employee3);
		employeeService.save(employee4);
		employeeService.save(employee5);
	}
}
