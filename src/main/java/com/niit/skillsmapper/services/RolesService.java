package com.niit.skillsmapper.services;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.skillsmapper.entity.Roles;
import com.niit.skillsmapper.repository.RolesRepository;

@Repository
@Transactional
public class RolesService implements RolesRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public boolean saveRoles(Roles roles) {
		try {
			sessionFactory.getCurrentSession().save(roles);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}

	}

}
