package com.adobe.prj.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.adobe.prj.dao.CustomerDao;
import com.adobe.prj.entity.Customer;

@Repository
public class CustomerDaoJpaImpl implements CustomerDao {
	@PersistenceContext
	private EntityManager em;
	@Override
	public List<Customer> getCustomer() {
		// TODO Auto-generated method stub
		TypedQuery<Customer> query= em.createQuery("select c from Customer c", Customer.class);
		return query.getResultList();
	}

}
