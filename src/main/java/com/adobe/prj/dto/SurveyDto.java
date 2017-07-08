package com.adobe.prj.dto;

import com.adobe.prj.entity.User;

public class SurveyDto implements Comparable <SurveyDto> {
	
	private int surveyId;
	private String surveyTitle;
	private String surveyDescription;
	private User createdBy;

	public SurveyDto() {}

	/**
	 * @param surveyId
	 * @param surveyTitle
	 * @param surveyDescription
	 * @param createdBy
	 */
	public SurveyDto(int surveyId, String surveyTitle, String surveyDescription, User createdBy) {
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
	public User getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}
	
	
	/* 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + ((surveyDescription == null) ? 0 : surveyDescription.hashCode());
		result = prime * result + surveyId;
		result = prime * result + ((surveyTitle == null) ? 0 : surveyTitle.hashCode());
		return result;
	}

	/* 
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
		SurveyDto other = (SurveyDto) obj;
		if (createdBy == null) {
			if (other.createdBy != null)
				return false;
		} else if (!createdBy.equals(other.createdBy))
			return false;
		if (surveyDescription == null) {
			if (other.surveyDescription != null)
				return false;
		} else if (!surveyDescription.equals(other.surveyDescription))
			return false;
		if (surveyId != other.surveyId)
			return false;
		if (surveyTitle == null) {
			if (other.surveyTitle != null)
				return false;
		} else if (!surveyTitle.equals(other.surveyTitle))
			return false;
		return true;
	}

	/* 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SurveyDto [surveyId=" + surveyId + ", surveyTitle=" + surveyTitle + ", surveyDescription="
				+ surveyDescription + ", createdBy=" + createdBy + "]";
	}

	@Override
	public int compareTo(SurveyDto o) {
		if (this.equals(o)) {
			return 0;
		}
		return o.surveyId - this.surveyId;
	}
	
}
