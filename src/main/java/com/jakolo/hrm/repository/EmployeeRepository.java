package com.jakolo.hrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jakolo.hrm.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
