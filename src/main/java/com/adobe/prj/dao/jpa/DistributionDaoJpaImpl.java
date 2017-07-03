package com.adobe.prj.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.adobe.prj.dao.DistributionDao;

@Repository
public class DistributionDaoJpaImpl implements DistributionDao {
	
	@PersistenceContext
	private EntityManager em;
}
