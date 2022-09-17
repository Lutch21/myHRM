package com.jakolo.hrm.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jakolo.hrm.entity.Department;
import com.jakolo.hrm.entity.Employee;
import com.jakolo.hrm.repository.DepartmentRepository;
import com.jakolo.hrm.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	private DepartmentRepository repository;

	public DepartmentServiceImpl(DepartmentRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public List<Employee> getEmployeesByDepartment(int id) {

		return repository.findById(id).get().getEmployees();

	}

	@Override
	public List<Department> getAllDepartments() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
