package com.adobe.prj.entity;

import javax.persistence.CascadeType;
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
public class Question implements Comparable <Question> {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="question_id")
	private int questionId;
	
	@Column(name="question_type")
	private QuestionType questionType;
	
	
	@ManyToOne(cascade = {CascadeType.ALL})
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
	
	public Question() {}

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

	public Question(Survey surveyId) {
		this.surveyId = surveyId;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", questionType=" + questionType + ", surveyId=" + surveyId
				+ ", qText=" + qText + ", opA=" + opA + ", opB=" + opB + ", opC=" + opC + ", opD=" + opD + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((opA == null) ? 0 : opA.hashCode());
		result = prime * result + ((opB == null) ? 0 : opB.hashCode());
		result = prime * result + ((opC == null) ? 0 : opC.hashCode());
		result = prime * result + ((opD == null) ? 0 : opD.hashCode());
		result = prime * result + ((qText == null) ? 0 : qText.hashCode());
		result = prime * result + questionId;
		result = prime * result + ((questionType == null) ? 0 : questionType.hashCode());
		result = prime * result + ((surveyId == null) ? 0 : surveyId.hashCode());
		return result;
	}

	/* compare the given object with current object.
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
		Question other = (Question) obj;
		if (opA == null) {
			if (other.opA != null)
				return false;
		} else if (!opA.equals(other.opA))
			return false;
		if (opB == null) {
			if (other.opB != null)
				return false;
		} else if (!opB.equals(other.opB))
			return false;
		if (opC == null) {
			if (other.opC != null)
				return false;
		} else if (!opC.equals(other.opC))
			return false;
		if (opD == null) {
			if (other.opD != null)
				return false;
		} else if (!opD.equals(other.opD))
			return false;
		if (qText == null) {
			if (other.qText != null)
				return false;
		} else if (!qText.equals(other.qText))
			return false;
		if (questionId != other.questionId)
			return false;
		if (questionType != other.questionType)
			return false;
		if (surveyId == null) {
			if (other.surveyId != null)
				return false;
		} else if (!surveyId.equals(other.surveyId))
			return false;
		return true;
	}

	/*
	 * Compare on the basis of question id.
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Question o) {
		if (this.equals(o)) {
			return 0;
		}
		return this.questionId - o.questionId;
	}


}
