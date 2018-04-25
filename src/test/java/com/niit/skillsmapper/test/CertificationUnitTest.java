package com.niit.skillsmapper.test;



import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.niit.skillsmapper.entity.Certificates;
import com.niit.skillsmapper.hibernate.HibernateConfiguration;
import com.niit.skillsmapper.repository.CertificationRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HibernateConfiguration.class)
public class CertificationUnitTest {

	@Autowired
	 CertificationRepository certificationRepository;
	@Autowired
	Certificates certification;
	

	//@Test
	public void test_add_certificate() {
		
		certification.setCertificateName("Oracle");
		certification.setTechnology("Oracle 12C");
		certification.setEmpId(30423);
		assertEquals(true, certificationRepository.addCertification(certification));

	}

	// @Test
	public void test_update_certification() {
		
		certification = certificationRepository.getCertificateById(1);
		certification.setCertificateName("OCA");
		certification.setTechnology("Core Java");

		assertEquals(true, certificationRepository.updateCertification(certification.getCertificateId()));
	}

	//@Test
	public void test_get_certification_by_id() {
	
		certification = certificationRepository.getCertificateById(1);
		assertEquals("OCA", certification.getCertificateName());
	}

	// @Test
	public void test_get_all_certifications() {
		List<Certificates> certifications = certificationRepository.getAllCertificates();
		certifications.forEach(System.out::println);
	}

	//@Test
	public void test_delete_certification() {
	
		certification.setCertificateId(1);
		assertEquals(true, certificationRepository.deleteCertification(certification.getCertificateId()));
	}
	@Test
   public void test_get_certificates_by_employee_id() {
	   
		List<Certificates> list = certificationRepository.getCertificatesByEmployeeId(30423);
		assertEquals(2, list.size());
   }
}
