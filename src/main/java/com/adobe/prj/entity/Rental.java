package com.adobe.prj.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="rentals")
public class Rental {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CID")
	private int rentalId;
	
	@Column(name="REG_NO")
	private String registrationNo;
	
	@Column(name="RENTAL_DATE")
	@Temporal(TemporalType.TIMESTAMP) // it joins rentalDate to the time stamp.
	private Date rentalDate;
	
	@ManyToOne
	@JoinColumn(name="RENTED_BY")
	private Customer customer;

	/**
	 * @return the rentalId
	 */
	public int getRentalId() {
		return rentalId;
	}

	/**
	 * @param rentalId the rentalId to set
	 */
	public void setRentalId(int rentalId) {
		this.rentalId = rentalId;
	}

	/**
	 * @return the registrationNo
	 */
	public String getRegistrationNo() {
		return registrationNo;
	}

	/**
	 * @param registrationNo the registrationNo to set
	 */
	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

	/**
	 * @return the rentalDate
	 */
	public Date getRentalDate() {
		return rentalDate;
	}

	/**
	 * @param rentalDate the rentalDate to set
	 */
	public void setRentalDate(Date rentalDate) {
		this.rentalDate = rentalDate;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
