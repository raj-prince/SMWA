package com.adobe.prj.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name="question")
@Entity
public class Question {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="question_id")
	private int questionId;
	
	@Column(name="question_type")
	private QuestionType questionType;
	
	@ManyToOne
	@JoinColumn(name="survey_id")
	private Survey surveyId;
	
	@Column(name="qtext")
	private String qText;
	
	@Column(name="opA")
	private String opA;
	
	@Column(name="opB")
	private String opB;
	
	@Column(name="opC")
	private String opC;
	
	@Column(name="opD")
	private String opD;
	
	/**
	 * 
	 */
	public Question() {
	}

	/**
	 * @param questionId
	 * @param questionType
	 * @param surveyId
	 */
	public Question(int questionId, QuestionType questionType, Survey surveyId) {
		this.questionId = questionId;
		this.questionType = questionType;
		this.surveyId = surveyId;
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
	 * @return the questionType
	 */
	public QuestionType getQuestionType() {
		return questionType;
	}

	/**
	 * @param questionType the questionType to set
	 */
	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
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
	
}
