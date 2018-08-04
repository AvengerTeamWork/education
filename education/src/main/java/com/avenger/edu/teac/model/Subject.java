package com.avenger.edu.teac.model;

/**
 * 学科类
 * @author zc
 * 2018年8月4日16:02:38
 */
public class Subject {

	private int id;
	private int majorId;
	private int courseId;
	private String time;
	
	public Subject() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMajorId() {
		return majorId;
	}

	public void setMajorId(int majorId) {
		this.majorId = majorId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
}
