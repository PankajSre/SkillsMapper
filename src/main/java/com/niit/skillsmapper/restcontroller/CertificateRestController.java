package com.niit.skillsmapper.restcontroller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.skillsmapper.entity.Certificaties;
import com.niit.skillsmapper.repository.CertificationRepository;

@RestController
@RequestMapping("/api/certificates")
public class CertificateRestController {

	@Autowired
	private CertificationRepository certificationRepository;

	@PostMapping("/add-certificate")
	public ResponseEntity<?> addCertificate(@RequestBody Certificaties certification) {
		if (certification != null) {
			certificationRepository.addCertification(certification);
			return new ResponseEntity<String>("Certification Added Successfully", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>("No Certificate Found", HttpStatus.CONFLICT);
		}
	}

	@GetMapping("/{certificateId}")
	public ResponseEntity<?> getCertificate(@PathVariable("certificateId") int certificateId) {
			Certificaties certification = certificationRepository.getCertificateById(certificateId);
			return new ResponseEntity<Certificaties>(certification, HttpStatus.OK);
	}

	@PostMapping("/update-{certificateId}-certificate")
	public ResponseEntity<?> updateCertificate(@PathVariable("certificateId") int certificateId) {
		if (certificateId > 0) {
			certificationRepository.updateCertification(certificateId);

			return new ResponseEntity<String>("Certification Updated Successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("No Certificate Found", HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/all-certificates")
	public ResponseEntity<?> getAllCertificates() {
		List<Certificaties> list = certificationRepository.getAllCertificates();
		return new ResponseEntity<List<Certificaties>>(list, HttpStatus.OK);

	}
	@PostMapping("/delete-{certificateId}-certificate")
	public ResponseEntity<?> deleteCertificate(@PathVariable("certificateId") int certificateId) {
		if (certificateId > 0) {
			certificationRepository.deleteCertification(certificateId);

			return new ResponseEntity<String>("Certification Deleted Successfully", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("No Certificate Found", HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/certificates-by-{empId}")
	public ResponseEntity<?> getAllCertificatesByEmployeeId(@PathVariable("empId") int empId) {
		List<Certificaties> list = certificationRepository.getCertificatesByEmployeeId(empId);
		return new ResponseEntity<List<Certificaties>>(list, HttpStatus.OK);

	}
}
