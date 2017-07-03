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
public class Response {
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

	/**
	 * 
	 */
	public Response() {
	}

	
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
	
	
}
