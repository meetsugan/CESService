package org.huit.ces.model;

public class Answer extends BaseModel{

	private long courseID;
	private long questionID;
	private String targetID;
	private String respondentID;
	private String response;
	
	public long getCourseID() {
		return courseID;
	}
	public void setCourseID(long courseID) {
		this.courseID = courseID;
	}
	public long getQuestionID() {
		return questionID;
	}
	public void setQuestionID(long questionID) {
		this.questionID = questionID;
	}
	public String getTargetID() {
		return targetID;
	}
	public void setTargetID(String targetID) {
		this.targetID = targetID;
	}
	public String getRespondentID() {
		return respondentID;
	}
	public void setRespondentID(String respondentID) {
		this.respondentID = respondentID;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	
	
	
}
