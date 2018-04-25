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
import com.niit.skillsmapper.entity.SkillDetails;
import com.niit.skillsmapper.repository.SkillsRepository;

@RestController
@RequestMapping("/api/skills")
public class SkillDetailsRestController {

	@Autowired
	private SkillsRepository skillsRepository;

	@PostMapping("/add-skills")
	public ResponseEntity<?> addEmployeeSkills(@RequestBody SkillDetails skillDetails) {
		if (skillDetails != null) {
			return new ResponseEntity<Boolean>(skillsRepository.addSkills(skillDetails), HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("Error", HttpStatus.CONFLICT);
		}
	}

	@GetMapping("/skill-details")
	public ResponseEntity<?> getAllEmployeeSkills() {
		List<SkillDetails> skillDetails = skillsRepository.getAllSkills();
		if (skillDetails != null) {
			return new ResponseEntity<List<SkillDetails>>(skillDetails, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("NO Skills Found", HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/update-{skillId}-skills")
	public ResponseEntity<?> updateSkills(@PathVariable("skillId") int skillId) {
		if (skillId > 0) {
			skillsRepository.updateSkills(skillId);
			return new ResponseEntity<String>("Updated Successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Error", HttpStatus.NOT_FOUND);
		}
	}



	@DeleteMapping("/delete-{skillId}-skills")
	public ResponseEntity<?> deleteSkills(@PathVariable("skillId") int skillId) {
		if (skillId > 0) {
			skillsRepository.deleteSkills(skillId);
			return new ResponseEntity<String>("Updated Successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Error", HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/{skillId}")
	public ResponseEntity<?> skillsById(@PathVariable("skillId") int skillId) {
		if (skillId > 0) {
			SkillDetails skills=skillsRepository.getSkillsById(skillId);
			return new ResponseEntity<SkillDetails>(skills, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Error", HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping(value="/search-by-{skillName}")
	public ResponseEntity<?> getAllEmployeesBySkillName(@PathVariable("skillName") String skillName)
	{
		List<Employee> employeeList=skillsRepository.getAllEmployeesBySkillName(skillName);
		if(employeeList != null)
		{
			return new ResponseEntity<List<Employee>>(employeeList,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("No Employee With these Skills",HttpStatus.NO_CONTENT);
		}
	}
}

