package com.jakolo.hrm.service;

import java.util.List;

import com.jakolo.hrm.entity.Department;
import com.jakolo.hrm.entity.Employee;

public interface EmployeeService {
	
	public Employee saveEmployee(Employee employee);

	public Employee  getEmployeeById(int id);

	public List<Employee> getAllEmployees();

	public Department getEmployeeDepartment(int id);

	public void deleteEmployee(int id);

}
