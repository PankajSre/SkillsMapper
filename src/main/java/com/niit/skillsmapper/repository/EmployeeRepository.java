package com.niit.skillsmapper.repository;

import java.util.List;

import com.niit.skillsmapper.entity.Employee;


public interface EmployeeRepository {
	
	public boolean saveEmployee(Employee employee);

	public boolean deleteEmployee(Employee employee);

	public boolean updateEmployee(Employee employee);

	public Employee getEmployeeById(int empId);

	public List<Employee> getAllEmployees();
	public boolean validateEmployee(int empId,String password);

}
