package com.jakolo.hrm.service;

import java.util.List;

import com.jakolo.hrm.entity.Department;
import com.jakolo.hrm.entity.Employee;

public interface DepartmentService {
	
	public List<Employee> getEmployeesByDepartment(int id);

	public List<Department> getAllDepartments();

}
