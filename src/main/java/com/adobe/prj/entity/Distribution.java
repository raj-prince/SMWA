package com.adobe.prj.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="distribution")
public class Distribution implements Comparable <Distribution> {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="distribution_id")
	private int distributionId;
	
	@OneToOne
	@JoinColumn(name="survey_id")
	private Survey surveyId;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User userId;
	
	@Column(name="survey_status")
	private SurveyStatus surveyStatus;
	
	@Column(name="distribution_timestamp")
	@Temporal(TemporalType.TIMESTAMP) 
	private Date distributionTimestamp;

	public Distribution() {}

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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Distribution [distributionId=" + distributionId + ", surveyId=" + surveyId + ", userId=" + userId
				+ ", surveyStatus=" + surveyStatus + ", distributionTimestamp=" + distributionTimestamp + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + distributionId;
		result = prime * result + ((distributionTimestamp == null) ? 0 : distributionTimestamp.hashCode());
		result = prime * result + ((surveyId == null) ? 0 : surveyId.hashCode());
		result = prime * result + ((surveyStatus == null) ? 0 : surveyStatus.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Distribution other = (Distribution) obj;
		if (distributionId != other.distributionId)
			return false;
		if (distributionTimestamp == null) {
			if (other.distributionTimestamp != null)
				return false;
		} else if (!distributionTimestamp.equals(other.distributionTimestamp))
			return false;
		if (surveyId == null) {
			if (other.surveyId != null)
				return false;
		} else if (!surveyId.equals(other.surveyId))
			return false;
		if (surveyStatus != other.surveyStatus)
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	
	/*
	 * Compare on the basis of distributionId.
	 */
	@Override
	public int compareTo(Distribution o) {
		if (this.equals(o)) {
			return 0;
		}
		return this.distributionId - o.distributionId;
	}
	
	
}
