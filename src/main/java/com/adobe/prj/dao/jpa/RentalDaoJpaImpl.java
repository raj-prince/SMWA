package com.adobe.prj.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.adobe.prj.dao.RentalDao;
import com.adobe.prj.entity.Rental;

@Repository
public class RentalDaoJpaImpl implements RentalDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void rent(Rental rental) {
		em.persist(rental);
	}

}
