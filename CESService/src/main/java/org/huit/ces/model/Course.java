package org.huit.ces.model;


public class Course extends BaseModel{

	private long courseID;
	private int academicYear;
	private int term;
	private boolean evaluateCourse;
	private String evaluationStartDate;
	private String  evaluationEndDate;
	private boolean publishResponses;
	public long getCourseID() {
		return courseID;
	}
	public void setCourseID(long courseID) {
		this.courseID = courseID;
	}
	public int getAcademicYear() {
		return academicYear;
	}
	public void setAcademicYear(int academicYear) {
		this.academicYear = academicYear;
	}
	
		public int getTerm() {
		return term;
	}
	public void setTerm(int term) {
		this.term = term;
	}
	public boolean isEvaluateCourse() {
		return evaluateCourse;
	}
	public void setEvaluateCourse(boolean evaluateCourse) {
		this.evaluateCourse = evaluateCourse;
	}
	/*public Date getEvaluationStartDate() {
		return evaluationStartDate;
	}
	public void setEvaluationStartDate(Date evaluationStartDate) {
		this.evaluationStartDate = evaluationStartDate;
	}
	public Date getEvaluationEndDate() {
		return evaluationEndDate;
	}
	public void setEvaluationEndDate(Date evaluationEndDate) {
		this.evaluationEndDate = evaluationEndDate;
	}*/
	public boolean isPublishResponses() {
		return publishResponses;
	}
	public void setPublishResponses(boolean publishResponses) {
		this.publishResponses = publishResponses;
	}
	public String getEvaluationStartDate() {
		return evaluationStartDate;
	}
	public void setEvaluationStartDate(String evaluationStartDate) {
		this.evaluationStartDate = evaluationStartDate;
	}
	public String getEvaluationEndDate() {
		return evaluationEndDate;
	}
	public void setEvaluationEndDate(String evaluationEndDate) {
		this.evaluationEndDate = evaluationEndDate;
	}

	
	
}
