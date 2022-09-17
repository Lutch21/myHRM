package com.jakolo.hrm.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jakolo.hrm.entity.Department;
import com.jakolo.hrm.entity.Employee;
import com.jakolo.hrm.exceptions.UserNotFoundException;
import com.jakolo.hrm.repository.EmployeeRepository;
import com.jakolo.hrm.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository repository;

	public EmployeeServiceImpl(EmployeeRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public Employee saveEmployee(Employee employee) {

		return repository.save(employee);
	}

	@Override
	public Employee getEmployeeById(int id) {
		
		return (repository.findById(id).isEmpty()?null:repository.findById(id).get());
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return repository.findAll();
	}

	@Override
	public Department getEmployeeDepartment(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get().getDepartment();
	}

	@Override
	public void deleteEmployee(int id) {
		boolean isEmpty  = repository.findById(id).isEmpty();
		
		if(isEmpty)
		{
			throw new UserNotFoundException("User with id: '"+id+"' does not exist");
		}else
			repository.deleteById(id);
		
	}

}
