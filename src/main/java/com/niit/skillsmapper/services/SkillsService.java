package com.niit.skillsmapper.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.skillsmapper.entity.Employee;
import com.niit.skillsmapper.entity.SkillDetails;
import com.niit.skillsmapper.repository.EmployeeRepository;
import com.niit.skillsmapper.repository.SkillsRepository;

@Repository(value = "skillsRepository")
@Transactional
public class SkillsService implements SkillsRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private EmployeeRepository employeeRepository;

	public boolean addSkills(SkillDetails skills) {
		try {
			sessionFactory.getCurrentSession().save(skills);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteSkills(int skillId) {
		try {
			sessionFactory.getCurrentSession().delete(getSkillsById(skillId));
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateSkills(int skillId) {
		try {
			sessionFactory.getCurrentSession().update(getSkillsById(skillId));
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public SkillDetails getSkillsById(int skillId) {

		return sessionFactory.getCurrentSession().get(SkillDetails.class, skillId);
	}

	public List<SkillDetails> getAllSkills() {

		return sessionFactory.getCurrentSession().createQuery("FROM SkillDetails").list();
	}

	public List<Employee> getAllEmployeesBySkillName(String skillName) {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("FROM SkillDetails where skillName='" + skillName + "'");
		List<SkillDetails> list = query.list();
		List<Employee> empList = new ArrayList<>();
		Employee emp = new Employee();
		for (SkillDetails skill : list) {
			emp = employeeRepository.getEmployeeById(skill.getEmpId());
			empList.add(emp);
		}
		return empList;
	}

	@SuppressWarnings("deprecation")
	public List<SkillDetails> getAllSkillsByEmployee(int empId) {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM SkillDetails where empId=?");
		query.setInteger(0, empId);
		List<SkillDetails> skillDetails = query.list();
		return skillDetails;
	}

	@Override
	public List<Employee> getAllEmployeesByMultipleSkills(String skillName) {
		List<String> skillNames = searchBySkills(skillName);
		try {
			Query query = sessionFactory.getCurrentSession()
					.createQuery("From SkillDetails where skillName in (:skillnames)");
			query.setParameterList("skillnames", skillNames);
			List<SkillDetails> list = query.list();
			List<Employee> employeeList = new ArrayList<>();
			Employee employee = new Employee();
			for (SkillDetails skill : list) {
				employee = employeeRepository.getEmployeeById(skill.getEmpId());
				if (!(employeeList.isEmpty())) {
					for (Employee emp : employeeList) {
						if (emp.getEmpId() != employee.getEmpId()) {
							employeeList.add(emp);
						}
					}
				} else {
					employeeList.add(employee);
				}
			}
			return employeeList;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}

	private List<String> searchBySkills(String skills) {
		List<String> allSkills = new ArrayList<>();
		String[] allStrings = skills.split(",");
		for (String s : allStrings) {
			String[] str = s.split(" ");
			if (str != null) {
				for (String ss : str)
					if (!(ss.equals("and") || ss.equals("or") || ss.equals("the"))) {
						allSkills.add(ss.trim());
					}
			}
		}

		return allSkills;
	}
}
