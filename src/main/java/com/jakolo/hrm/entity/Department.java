package com.jakolo.hrm.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotEmpty
	private String code;
	@NotEmpty
	private String name;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "department",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Employee> employees;
	
	public Department() {
		super();
	}

	public Department(int id, @NotEmpty String code, @NotEmpty String name) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addEmployee(Employee emp) {
		employees.add(emp);
		
	}
	
	@Override
	public String toString() {
		return "Department [id=" + id + ", code=" + code + ", name=" + name + "]";
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	
	

}
