package com.jakolo.hrm.entity;

import java.time.LocalDate;
import java.util.Formatter;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jakolo.hrm.entity.enums.EnumNamePattern;
import com.jakolo.hrm.entity.enums.Gender;
import com.jakolo.hrm.entity.enums.ValidGender1;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Size(min = 2, message = "Employee first name should be at least 2 characters")
	private String firstName;
	@Size(min = 3, message = "Employee last name should be at least 3 characters")
	private String lastName;
	private String midName;
	@Past
	@NotNull(message = "Birth date cannot be null")
	private LocalDate birthDate;
	@NotNull
	private LocalDate employedDate;

	private String supervisorId;
	@Email
	private String email;

	private String address;

	private boolean isActive;
	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="DEPT_ID", referencedColumnName = "id")
	private Department department;

	/*
	 * @ValidGender1(message="Value for gender is not valid}") private String
	 * gender1;
	 */

	@EnumNamePattern(regexp = "FEMALE|MALE|TRANSGENDER")
	private Gender gender;

	public Employee() {
		super();
	}

	public Employee(String firstName, String lastName, LocalDate birthDate, LocalDate employedDate,
			/* Department department, */ String supervisorId, String email, String address) {
		super();
		// this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.employedDate = employedDate;
		// this.department = department;
		this.supervisorId = supervisorId;
		this.email = email;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public LocalDate getEmployedDate() {
		return employedDate;
	}

	public void setEmployedDate(LocalDate employedDate) {
		this.employedDate = employedDate;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getSupervisorId() {
		return supervisorId;
	}

	public void setSupervisorId(String supervisorId) {
		this.supervisorId = supervisorId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMidName() {
		return midName;
	}

	public void setMidName(String midName) {
		this.midName = midName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	/*
	 * public String getGender1() { return gender1; }
	 * 
	 * public void setGender1(String gender1) { this.gender1 = gender1; }
	 */
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate
				+ ", employedDate=" + employedDate + ", supervisorId=" + supervisorId + ", email=" + email
				+ ", address=" + address + "]";
	}

}
