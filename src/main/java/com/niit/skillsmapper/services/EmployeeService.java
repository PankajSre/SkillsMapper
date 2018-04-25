package com.niit.skillsmapper.services;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.skillsmapper.entity.Employee;
import com.niit.skillsmapper.repository.EmployeeRepository;

@Repository(value = "employeeRepository")
@Transactional
public class EmployeeService implements EmployeeRepository {

	private SessionFactory sessionFactory;

	@Autowired
	public EmployeeService(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	public boolean saveEmployee(Employee employee) {
		try {
			sessionFactory.getCurrentSession().save(employee);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteEmployee(Employee employee) {
		try {
			sessionFactory.getCurrentSession().delete(employee);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateEmployee(Employee employee) {
		try {
			sessionFactory.getCurrentSession().update(employee);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public Employee getEmployeeById(int empId) {

		return sessionFactory.getCurrentSession().get(Employee.class, empId);
	}

	public List<Employee> getAllEmployees() {
		return sessionFactory.getCurrentSession().createQuery("FROM Employee").list();
	}

	public boolean validateEmployee(int empId, String password) {
		String hql = "FROM Employee where empId=? and password=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, empId);
		query.setString(1, password);
		Employee emp = (Employee) query.uniqueResult();

		if (emp != null) {
			return true;
		} else {
			return false;
		}

	}

}
