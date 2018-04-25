package com.niit.skillsmapper.repository;

import java.util.List;

import com.niit.skillsmapper.entity.Employee;
import com.niit.skillsmapper.entity.SkillDetails;

public interface SkillsRepository {

	public boolean addSkills(SkillDetails skills);

	public boolean deleteSkills(int skillId);

	public boolean updateSkills(int skillId);

	public SkillDetails getSkillsById(int skillId);

	public List<SkillDetails> getAllSkills();

	public List<Employee> getAllEmployeesBySkillName(String skillName);

	public List<SkillDetails> getAllSkillsByEmployee(int empId);
	List<Employee> getAllEmployeesByMultipleSkills(String skillName);

}
