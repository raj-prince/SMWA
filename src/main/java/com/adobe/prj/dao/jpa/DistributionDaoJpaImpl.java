package com.adobe.prj.dao.jpa;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.adobe.prj.dao.DistributionDao;
import com.adobe.prj.entity.Distribution;
import com.adobe.prj.entity.Survey;
import com.adobe.prj.entity.User;

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

	@Override
	public List<Distribution> getDistributedSurveys() {
		TypedQuery<Distribution> query = em.createQuery("from Distribution", Distribution.class);
		return query.getResultList();
	}
	
	@Override
	public int cntClosedStatus(int surveyId) {
		TypedQuery<Integer> query = 
				em.createQuery("select count(*) from Distribution d group by surveyId having d.SurveyStatus="+1, Integer.class);
		return query.getSingleResult();
	}
	
	public List<User> getUnsentUsers(Survey s) {
		TypedQuery<User> query = em.createQuery("select u from User u", User.class);
		 List<User> allUsers = query.getResultList();
		 TypedQuery<User> query2 = em.createQuery("select d.userId from Distribution d where d.surveyId="+s.getSurveyId(), User.class);
		 List<User> alreadyDistributed= query2.getResultList();
		 Set<User> allUsersSet= new HashSet<>(allUsers);
		 Set<User> alreadyDistributedSet= new HashSet<>(alreadyDistributed);
		 allUsersSet.removeAll(alreadyDistributedSet);
		 List<User> l1=new ArrayList<User>(allUsersSet);
		 return l1;
//		return null;
	}

	@Override
	public int cntOpenStatus(int surveyId) {
		TypedQuery<Integer> query = 
				em.createQuery("select count(*) from Distribution d group by surveyId having d.SurveyStatus="+0, Integer.class);
		return query.getSingleResult();
	}
	
	@Override
	public Date getTimeStamp(int surveyId) {
		TypedQuery<Date> query = 
				em.createQuery("select distinct d.Date from Distribution d where d.surveyId=" + surveyId, Date.class);
		return query.getSingleResult();
	}
}
