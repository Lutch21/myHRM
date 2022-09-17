package com.jakolo.hrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jakolo.hrm.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
