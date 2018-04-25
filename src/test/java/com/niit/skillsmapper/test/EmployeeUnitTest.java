package com.niit.skillsmapper.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.skillsmapper.entity.Employee;
import com.niit.skillsmapper.repository.EmployeeRepository;



public class EmployeeUnitTest {

	private static EmployeeRepository employeeRepository;
	private static Employee employee;
	private static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.skillsmapper");
		context.refresh();
		employeeRepository =(EmployeeRepository) context.getBean("employeeRepository");
		employee = (Employee) context.getBean("employee");
	}

	//@Test
	public void test_add_employee_success() {
		employee.setEmpEmailId("pankaj.saini85@gmail.com");
		employee.setPassword("pankaj");
		employee.setEmpDepartment("Global Retail Business");
		employee.setEmpLocation("Preet Vihar , New Delhi");
		employee.setEmpName("Pankaj Saini");
		employee.setStudentTaught(123);
		employee.setYearsOfExp(8);
		employee.setStatus(true);
		employee.setManagerId(12345);
		employee.setEmpId(22222);
		employee.setDateOfJoining(new Date());
		assertEquals(true, employeeRepository.saveEmployee(employee));

	}
	
	//@Test(expected =Exception.class)
	public void test_add_employee_failure() {
		employee.setEmpEmailId("advik.saini85@gmail.com");
		employee.setPassword("123456");
		employee.setEmpDepartment("Global Retail Business");
		employee.setEmpLocation("Preet Vihar , New Delhi");
		employee.setEmpName("Advik Saini");
		employee.setStudentTaught(123);
		employee.setYearsOfExp(8);
		employee.setStatus(true);
		employee.setManagerId(12345);
		employee.setEmpId(30490);
		employee.setDateOfJoining(new Date());
		assertEquals(false, employeeRepository.saveEmployee(employee));

	}

	// @Test
	public void test_update_employee() {

		employee = employeeRepository.getEmployeeById(1);
		employee.setEmpDepartment("Career Education Business");

		assertEquals(true, employeeRepository.updateEmployee(employee));
	}

	// @Test
	public void test_get_employee_by_id() {
		employee = employeeRepository.getEmployeeById(2);
		assertEquals("pankaj.saini85@gmail.com", employee.getEmpEmailId());
		System.out.println(employee);
	}

	// @Test
	public void test_get_all_employees() {
		List<Employee> employees = employeeRepository.getAllEmployees();

		assertEquals(2, employees.size());
		employees.forEach(System.out::println);
	}

	//@Test
	public void test_delete_employee() {
		employee.setEmpId(6);
		assertEquals(true, employeeRepository.deleteEmployee(employee));
	}
	@Test
	public void test_employee_login_success() {
		assertEquals(true, employeeRepository.validateEmployee(1, "123456"));
	}
}
