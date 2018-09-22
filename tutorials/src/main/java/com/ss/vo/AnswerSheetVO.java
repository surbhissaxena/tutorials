package com.ss.vo;

public class AnswerSheetVO {

	private int id;
	private int questionId;
	private int subId;
	private int userId;
	private String answer;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public int getSubId() {
		return subId;
	}
	public void setSubId(int subId) {
		this.subId = subId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public AnswerSheetVO(){
		
	}
	@Override
	public String toString() {
		return "AnswerSheetVO [id=" + id + ", questionId=" + questionId
				+ ", subId=" + subId + ", userId=" + userId + ", answer="
				+ answer + "]";
	}
	
	
	
}
