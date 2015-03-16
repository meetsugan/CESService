package org.huit.ces.model;

public class User extends BaseModel{

	private String harvardID;
	private String title;
	private String courseRole;
	private long courseID;
	
	public String getHarvardID() {
		return harvardID;
	}
	public void setHarvardID(String harvardID) {
		this.harvardID = harvardID;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCourseRole() {
		return courseRole;
	}
	public void setCourseRole(String courseRole) {
		this.courseRole = courseRole;
	}
	public long getCourseID() {
		return courseID;
	}
	public void setCourseID(long courseID) {
		this.courseID = courseID;
	}
}
