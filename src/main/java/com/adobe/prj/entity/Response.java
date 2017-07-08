package com.adobe.prj.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name="response")
@Entity
public class Response implements Comparable <Response> {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="response_id")
	private int responseId;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User userId;
	
	@ManyToOne
	@JoinColumn(name="question_id")
	private Question questionId;
	
	@Column(name="response_text")
	private String responseText;

	public Response() {}

	/**
	 * @param responseId
	 * @param userId
	 * @param questionId
	 * @param responseText
	 */
	public Response(int responseId, User userId, Question questionId, String responseText) {
		this.responseId = responseId;
		this.userId = userId;
		this.questionId = questionId;
		this.responseText = responseText;
	}
	
	

	/**
	 * @return the responseId
	 */
	public int getResponseId() {
		return responseId;
	}


	/**
	 * @param responseId the responseId to set
	 */
	public void setResponseId(int responseId) {
		this.responseId = responseId;
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
	 * @return the questionId
	 */
	public Question getQuestionId() {
		return questionId;
	}

	/**
	 * @param questionId the questionId to set
	 */
	public void setQuestionId(Question questionId) {
		this.questionId = questionId;
	}

	/**
	 * @return the responseText
	 */
	public String getResponseText() {
		return responseText;
	}

	/**
	 * @param responseText the responseText to set
	 */
	public void setResponseText(String responseText) {
		this.responseText = responseText;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((questionId == null) ? 0 : questionId.hashCode());
		result = prime * result + responseId;
		result = prime * result + ((responseText == null) ? 0 : responseText.hashCode());
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
		Response other = (Response) obj;
		if (questionId == null) {
			if (other.questionId != null)
				return false;
		} else if (!questionId.equals(other.questionId))
			return false;
		if (responseId != other.responseId)
			return false;
		if (responseText == null) {
			if (other.responseText != null)
				return false;
		} else if (!responseText.equals(other.responseText))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Response [responseId=" + responseId + ", userId=" + userId + ", questionId=" + questionId
				+ ", responseText=" + responseText + "]";
	}

	/*
	 * Compare on the basis response id.
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Response o) {
		if (this.equals(o)) {
			return 0;
		}
		return o.responseId - this.responseId;
	}
}
