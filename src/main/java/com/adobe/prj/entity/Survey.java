package com.adobe.prj.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name="survey")
@Entity
public class Survey {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="survey_id")
	private int surveyId;
	
	@Column(name="survey_title")
	private String surveyTitle;
	
	@Column(name="survey_description")
	private String surveyDescription;
	
//	@ManyToOne
//	@JoinColumn(name="created_by")
	@Column
	private String createdBy;

	
	/**
	 * 
	 */
	public Survey() {
	}

	/**
	 * @param surveyId
	 * @param surveyTitle
	 * @param surveyDescription
	 * @param createdBy
	 */
	public Survey(int surveyId, String surveyTitle, String surveyDescription, String createdBy) {
		this.surveyId = surveyId;
		this.surveyTitle = surveyTitle;
		this.surveyDescription = surveyDescription;
		this.createdBy = createdBy;
	}

	/**
	 * @return the surveyTitle
	 */
	public String getSurveyTitle() {
		return surveyTitle;
	}

	/**
	 * @param surveyTitle the surveyTitle to set
	 */
	public void setSurveyTitle(String surveyTitle) {
		this.surveyTitle = surveyTitle;
	}

	/**
	 * @return the surveyDescription
	 */
	public String getSurveyDescription() {
		return surveyDescription;
	}

	/**
	 * @param surveyDescription the surveyDescription to set
	 */
	public void setSurveyDescription(String surveyDescription) {
		this.surveyDescription = surveyDescription;
	}

	/**
	 * @return the surveyId
	 */
	public int getSurveyId() {
		return surveyId;
	}

	/**
	 * @param surveyId the surveyId to set
	 */
	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param string the createdBy to set
	 */
	public void setCreatedBy(String string) {
		this.createdBy = string;
	}

	@Override
	public String toString() {
		return "Survey [surveyId=" + surveyId + ", surveyTitle=" + surveyTitle + ", surveyDescription="
				+ surveyDescription + ", createdBy=" + createdBy + "]";
	}
	
}
