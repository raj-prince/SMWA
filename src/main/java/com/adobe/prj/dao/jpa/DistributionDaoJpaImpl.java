package com.adobe.prj.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.adobe.prj.dao.DistributionDao;
import com.adobe.prj.entity.Distribution;
import com.adobe.prj.entity.Survey;

@Repository
public class DistributionDaoJpaImpl implements DistributionDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public int distributeSurvey(Distribution distribution) {
		em.persist(distribution);
		return distribution.getDistributionId();
	}

	@Override
	public int dis(Distribution distribution) {
		// TODO Auto-generated method stub
		em.persist(distribution);
		return distribution.getDistributionId();
	}

	
}
