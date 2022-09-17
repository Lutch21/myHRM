package com.jakolo.hrm.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jakolo.hrm.entity.Department;
import com.jakolo.hrm.entity.Employee;
import com.jakolo.hrm.service.DepartmentService;

@RestController
//@Slf4j
public class DepartmentController {

	private DepartmentService departmentService;

	public DepartmentController(DepartmentService departmentService) {
		super();
		this.departmentService = departmentService;
	}

	@GetMapping("/departments")
	public List<Department> getAllDepartments() {

		return departmentService.getAllDepartments();
	}

	@GetMapping("/departments/{id}/employees")
	public List<Employee> getEmployeesByDepartmentId(@PathVariable("id") int id) {

		return departmentService.getEmployeesByDepartment(id);

	}

}
