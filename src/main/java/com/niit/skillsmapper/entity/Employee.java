package com.niit.skillsmapper.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "employee")
public class Employee implements Serializable {

	private static final long serialVersionUID = 4411276707786806733L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int empId;
	private String empEmailId;
	private String password;
	private String empName;
	private String empDepartment;
	private String empLocation;
	private double yearsOfExp;
	private int studentTaught;
	private boolean status = false;
	private int managerId;
	private Date dateOfJoining;
	private String role;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpEmailId() {
		return empEmailId;
	}
	public void setEmpEmailId(String empEmailId) {
		this.empEmailId = empEmailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpDepartment() {
		return empDepartment;
	}
	public void setEmpDepartment(String empDepartment) {
		this.empDepartment = empDepartment;
	}
	public String getEmpLocation() {
		return empLocation;
	}
	public void setEmpLocation(String empLocation) {
		this.empLocation = empLocation;
	}
	public double getYearsOfExp() {
		return yearsOfExp;
	}
	public void setYearsOfExp(double yearsOfExp) {
		this.yearsOfExp = yearsOfExp;
	}
	public int getStudentTaught() {
		return studentTaught;
	}
	public void setStudentTaught(int studentTaught) {
		this.studentTaught = studentTaught;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	

	
}
