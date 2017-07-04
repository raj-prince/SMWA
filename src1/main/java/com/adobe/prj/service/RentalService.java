package com.adobe.prj.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adobe.prj.dao.CustomerDao;
import com.adobe.prj.dao.RentalDao;
import com.adobe.prj.entity.Customer;
import com.adobe.prj.entity.Rental;

@Service
@Transactional
public class RentalService {
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private RentalDao rentalDao;
	
	public List<Customer> getCustomers()
	{
		return customerDao.getCustomer();
		
	}
	
	public void rental (Rental rental)
	{
		rentalDao.rent(rental);
		
	}
}
