package com.adobe.prj.dto;


import com.adobe.prj.entity.User;


public class ResponseDto implements Comparable <ResponseDto> {
	
	private int responseId;
	private User userId;
	private int questionId;
	private String responseText;
	private int qid;
	
	
	public ResponseDto() {}
	
	/**
	 * @param responseId
	 * @param userId
	 * @param questionId
	 * @param responseText
	 * @param qid
	 */
	public ResponseDto(int responseId, User userId, int questionId, String responseText, int qid) {
		this.responseId = responseId;
		this.userId = userId;
		this.questionId = questionId;
		this.responseText = responseText;
		this.qid = qid;
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

	/* 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + qid;
		result = prime * result + questionId;
		result = prime * result + responseId;
		result = prime * result + ((responseText == null) ? 0 : responseText.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		ResponseDto other = (ResponseDto) obj;
		if (qid != other.qid)
			return false;
		if (questionId != other.questionId)
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

	/*
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ResponseDto [responseId=" + responseId + ", userId=" + userId + ", questionId=" + questionId
				+ ", responseText=" + responseText + ", qid=" + qid + "]";
	}

	/*
	 * Compare on the basis of responseId.
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(ResponseDto o) {
		if (this.equals(o)) {
			return 0;
		}
		return o.responseId - this.responseId;
	}
}
