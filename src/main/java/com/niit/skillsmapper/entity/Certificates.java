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
@Table(name = "certification")
public class Certificates implements Serializable {

	private static final long serialVersionUID = 4606602670766458424L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int certificateId;
	private String certificateName;
	private String technology;
	private int empId;
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	

	public int getCertificateId() {
		return certificateId;
	}

	public void setCertificateId(int certificateId) {
		this.certificateId = certificateId;
	}

	public String getCertificateName() {
		return certificateName;
	}

	public void setCertificateName(String certificateName) {
		this.certificateName = certificateName;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	@Override
	public String toString() {

		return certificateId + "  :  " + certificateName + "  :  " + technology;
	}

}
