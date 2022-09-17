package com.jakolo.hrm.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jakolo.hrm.entity.Department;
import com.jakolo.hrm.entity.Employee;
import com.jakolo.hrm.exceptions.UserNotFoundException;
import com.jakolo.hrm.service.DepartmentService;
import com.jakolo.hrm.service.EmployeeService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class EmployeeController {
	
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@PostMapping("/employees")
	public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee) {
		log.info("Inside saveEmployee controller");
		Employee savedEmployee =employeeService.saveEmployee(employee);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedEmployee.getId())
				.toUri();
		return ResponseEntity.created(location).build();
		
	}
	
	//Get all employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		List<Employee> existEmployees = employeeService.getAllEmployees();
		
		log.info("number of employees: "+existEmployees.size());
		
		for (Employee employee : existEmployees) {
			log.info("Employee first name: "+employee.getFirstName());
		}
		
		return existEmployees;
		
	}
	
	@GetMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		Employee existEmployee = employeeService.getEmployeeById(id);
		
		if(existEmployee == null)
			throw new UserNotFoundException("Employee with id: "+id +" does not exist");
		
		return existEmployee;
		
	}
	@GetMapping("/employees/{id}/department")
	public Department getEmployeeDepartment(@PathVariable("id") int id) {
		Department dep = employeeService.getEmployeeDepartment(id);
		
		//if we dont want to return the list of employees for that department
		dep.setEmployees(null);
		return dep;
		
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id) {
		
		employeeService.deleteEmployee(id);
		
		return new ResponseEntity<String>(("Employee with id '"+id+"' deleted successfully"), null, 200);
		
	}

}
