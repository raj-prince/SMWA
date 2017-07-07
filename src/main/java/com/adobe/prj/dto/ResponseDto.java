package com.adobe.prj.dto;


import com.adobe.prj.entity.Question;
import com.adobe.prj.entity.Survey;
import com.adobe.prj.entity.User;


public class ResponseDto {
		private int responseId;
	
		private User userId;
	
	
	private int questionId;
	
	
	private String responseText;
	private int qid;
	/**
	 * 
	 */
	public ResponseDto() {
	}
	
	

	
	/**
	 * @param responseId
	 * @param userId
	 * @param questionId
	 * @param responseText
	 */

	
	

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
	public int getQuestionId() {
		return questionId;
	}

	/**
	 * @param questionId the questionId to set
	 */
	public void setQuestionId(int questionId) {
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
