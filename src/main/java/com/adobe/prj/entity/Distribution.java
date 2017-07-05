package com.adobe.prj.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="distribution")
public class Distribution {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="distribution_id")
	private int distributionId;
	
	@ManyToOne
	@JoinColumn(name="survey_id")
	private Survey surveyId;
	
	@OneToMany
	@JoinColumn(name="user_id")
	private User userId;
	
	@Column(name="survey_status")
	private SurveyStatus surveyStatus;
	
	@Column(name="distribution_timestamp")
	@Temporal(TemporalType.TIMESTAMP) 
	private Date distributionTimestamp;

	/**
	 * 
	 */
	public Distribution() {
	}

	/**
	 * @param distributionId
	 * @param surveyId
	 * @param userId
	 * @param surveyStatus
	 * @param distributionTimestamp
	 */
	public Distribution(int distributionId, Survey surveyId, User userId, SurveyStatus surveyStatus,
			Date distributionTimestamp) {
		this.distributionId = distributionId;
		this.surveyId = surveyId;
		this.userId = userId;
		this.surveyStatus = surveyStatus;
		this.distributionTimestamp = distributionTimestamp;
	}

	/**
	 * @return the distributionId
	 */
	public int getDistributionId() {
		return distributionId;
	}

	/**
	 * @param distributionId the distributionId to set
	 */
	public void setDistributionId(int distributionId) {
		this.distributionId = distributionId;
	}

	/**
	 * @return the surveyId
	 */
	public Survey getSurveyId() {
		return surveyId;
	}

	/**
	 * @param surveyId the surveyId to set
	 */
	public void setSurveyId(Survey surveyId) {
		this.surveyId = surveyId;
	}

	/**
	 * @return the userId
	 */
	public User getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(User userId) {
		this.userId = userId;
	}

	/**
	 * @return the surveyStatus
	 */
	public SurveyStatus getSurveyStatus() {
		return surveyStatus;
	}

	/**
	 * @param surveyStatus the surveyStatus to set
	 */
	public void setSurveyStatus(SurveyStatus surveyStatus) {
		this.surveyStatus = surveyStatus;
	}

	/**
	 * @return the distributionTimestamp
	 */
	public Date getDistributionTimestamp() {
		return distributionTimestamp;
	}

	/**
	 * @param distributionTimestamp the distributionTimestamp to set
	 */
	public void setDistributionTimestamp(Date distributionTimestamp) {
		this.distributionTimestamp = distributionTimestamp;
	}
	
	
}
