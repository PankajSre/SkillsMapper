package com.niit.skillsmapper.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.niit.skillsmapper")
public class CertificateMicroservice {

	public static void main(String[] args) {
		SpringApplication.run(CertificateMicroservice.class, args);
	}
}
