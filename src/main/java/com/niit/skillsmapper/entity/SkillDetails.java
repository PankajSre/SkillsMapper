package com.niit.skillsmapper.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "skillDetails")
public class SkillDetails implements Serializable {

	private static final long serialVersionUID = 3858721390642290521L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int skillId;
	private int empId;
	private String skillName;
	private double numberOfHoursTought;
	private double totalYrsOfExp;
	private double ratings;

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	public double getNumberOfHoursTought() {
		return numberOfHoursTought;
	}

	public void setNumberOfHoursTought(double numberOfHoursTought) {
		this.numberOfHoursTought = numberOfHoursTought;
	}

	public double getTotalYrsOfExp() {
		return totalYrsOfExp;
	}

	public void setTotalYrsOfExp(double totalYrsOfExp) {
		this.totalYrsOfExp = totalYrsOfExp;
	}

	public double getRatings() {
		return ratings;
	}

	public void setRatings(double ratings) {
		this.ratings = ratings;
	}

}
