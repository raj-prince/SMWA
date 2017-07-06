package com.adobe.prj.dto;

import com.adobe.prj.entity.User;

public class SurveyDto {
	
	private int surveyId;
	
	private String surveyTitle;
	
		private String surveyDescription;
	
	private User createdBy;

	
	/**
	 * 
	 */


	/**
	 * @param surveyId
	 * @param surveyTitle
	 * @param surveyDescription
	 * @param createdBy
	 */
	
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
	public User getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}
	
}
