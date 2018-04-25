package com.niit.skillsmapper.services;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.skillsmapper.entity.Certificates;
import com.niit.skillsmapper.repository.CertificationRepository;

@Repository(value = "certificationRepository")
@Transactional
public class CertificationService implements CertificationRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public boolean addCertification(Certificates certification) {
		try {
			sessionFactory.getCurrentSession().save(certification);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteCertification(int certificateId) {
		try {
			sessionFactory.getCurrentSession().delete(getCertificateById(certificateId));
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateCertification(int certificateId) {
		try {
			sessionFactory.getCurrentSession().update(getCertificateById(certificateId));
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
	}

	public Certificates getCertificateById(int certificationId) {
		return sessionFactory.getCurrentSession().get(Certificates.class, certificationId);
	}

	public List<Certificates> getAllCertificates() {

		return sessionFactory.getCurrentSession().createQuery("FROM Certificates").list();
	}


	@Override
	public List<Certificates> getCertificatesByEmployeeId(int empId) {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Certificates where empId=?");
		query.setInteger(0, empId);
		List<Certificates> list = query.list();
		return list;
	}

}
