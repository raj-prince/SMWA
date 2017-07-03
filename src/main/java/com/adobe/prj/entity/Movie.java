package com.adobe.prj.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name="movies")
@Entity // it say hibernate to convert it into MYSQL type.
public class Movie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) // since in mysql id is autoincremented hence no explicitly given by java
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="year")
	private int year;
	/**
	 * 
	 */
	public Movie() {
	}
	
	/**
	 * @param id
	 * @param name
	 * @param year
	 */
	public Movie(int id, String name, int year) {
		this.id = id;
		this.name = name;
		this.year = year;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}
	
	
}
