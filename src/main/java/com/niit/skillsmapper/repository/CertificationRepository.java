package com.niit.skillsmapper.repository;

import java.util.List;

import com.niit.skillsmapper.entity.Certificates;



public interface CertificationRepository {
	
	public boolean addCertification(Certificates certification);

	public boolean deleteCertification(int certificateId);

	public boolean updateCertification(int certificateId);

	public Certificates getCertificateById(int certificationId);

	public List<Certificates> getAllCertificates();
	
	public List<Certificates> getCertificatesByEmployeeId(int empId);

}
