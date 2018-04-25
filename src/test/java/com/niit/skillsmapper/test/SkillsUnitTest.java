package com.niit.skillsmapper.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.niit.skillsmapper.entity.Employee;
import com.niit.skillsmapper.entity.SkillDetails;
import com.niit.skillsmapper.hibernate.HibernateConfiguration;
import com.niit.skillsmapper.repository.SkillsRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HibernateConfiguration.class)
public class SkillsUnitTest {

	@Autowired
	private SkillsRepository skillsRepository;
	@Autowired
	private SkillDetails skillDetails;
	
	//@Test
	public void test_add_skills() {
		skillDetails.setEmpId(30423);
		skillDetails.setNumberOfHoursTought(234.5);
		skillDetails.setRatings(4.8);
		skillDetails.setSkillName("Core Java");
		skillDetails.setTotalYrsOfExp(8);
		assertEquals(true, skillsRepository.addSkills(skillDetails));
	}
	
	//@Test
	public void test_get_all_employees_by_skillname() {
		
		List<Employee> list = skillsRepository.getAllEmployeesBySkillName("Core Java");
		assertEquals(1, list.size());
	}
	//@Test
	public void test_get_skills_by_employee() {
		List<SkillDetails> list = skillsRepository.getAllSkillsByEmployee(30423);
	    assertEquals(1, list.size());
	    list.forEach(System.out::println);
	}
	//@Test
    public void test_search_by_skills() {
    	List<Employee> skillList = skillsRepository.getAllEmployeesByMultipleSkills("Core Java");
    	assertEquals(1, skillList.size());
    	skillList.forEach(System.out::println);
    }
}
