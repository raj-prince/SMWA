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

	public Question(int questionId, QuestionType questionType, Survey surveyId, String qText, String opA, String opB,
			String opC, String opD) {
		this.questionId = questionId;
		this.questionType = questionType;
		this.surveyId = surveyId;
		this.qText = qText;
		this.opA = opA;
		this.opB = opB;
		this.opC = opC;
		this.opD = opD;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public QuestionType getQuestionType() {
		return questionType;
	}

	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}

	public Survey getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(Survey surveyId) {
		this.surveyId = surveyId;
	}

	public String getqText() {
		return qText;
	}

	public void setqText(String qText) {
		this.qText = qText;
	}

	public String getOpA() {
		return opA;
	}

	public void setOpA(String opA) {
		this.opA = opA;
	}

	public String getOpB() {
		return opB;
	}

	public void setOpB(String opB) {
		this.opB = opB;
	}

	public String getOpC() {
		return opC;
	}

	public void setOpC(String opC) {
		this.opC = opC;
	}

	public String getOpD() {
		return opD;
	}

	public void setOpD(String opD) {
		this.opD = opD;
	}


}
