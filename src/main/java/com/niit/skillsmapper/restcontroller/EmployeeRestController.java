package com.niit.skillsmapper.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.skillsmapper.entity.Employee;
import com.niit.skillsmapper.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/employee")
public class EmployeeRestController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping("/get-all-employees")
	public ResponseEntity<List<Employee>> getAllEmployees() {

		List<Employee> list = employeeRepository.getAllEmployees();
		return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
	}

	@PostMapping("/save-employee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		if (employee != null) {
			employeeRepository.saveEmployee(employee);
			return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Employee>(employee, HttpStatus.CONFLICT);
		}
	}

	@PostMapping("/update-{empId}-employee")
	public ResponseEntity<String> updateEmployee(@PathVariable("empId") int empId) {
		if (employeeRepository.getEmployeeById(empId).getEmpId() != 0) {
			employeeRepository.updateEmployee(employeeRepository.getEmployeeById(empId));
			return new ResponseEntity<String>("Updated Successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Error", HttpStatus.CONFLICT);
		}
	}

	@DeleteMapping("/delete-{empId}-employee")
	public ResponseEntity<String> deleteEmployee(@PathVariable("empId") int empId) {
		if (employeeRepository.getEmployeeById(empId).getEmpId() != 0) {
			employeeRepository.deleteEmployee(employeeRepository.getEmployeeById(empId));
			return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Error", HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/employee--{empId}")
	public ResponseEntity<?> getEmployeeById(@PathVariable("empId") int empId) {
		if (employeeRepository.getEmployeeById(empId).getEmpId() != 0) {
			Employee employee = employeeRepository.getEmployeeById(empId);
			return new ResponseEntity<Employee>(employee, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<String>("Employee Not Found", HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/login-page")
	public ResponseEntity<?> loginValidation(@RequestBody Employee employee) {
		if (employee.getEmpId() != 0 & employee.getEmpId() > 0) {
			boolean login = employeeRepository.validateEmployee(employee.getEmpId(), employee.getPassword());
			return new ResponseEntity<String>("Login Success", HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<String>("Employee Not Found", HttpStatus.NOT_FOUND);
		}
	}

}
