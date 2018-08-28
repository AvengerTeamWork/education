package com.avenger.edu.teac.model;

public class TeacTable {

	private String gradeNum;
	private int term;
	private int week;
	private int day;
	private String part;
	private String address;
	private String lesson;
	private String major;
	
	public TeacTable() {
		
	}
	
	
	public String getGradeNum() {
		return gradeNum;
	}


	public void setGradeNum(String gradeNum) {
		this.gradeNum = gradeNum;
	}


	public int getTerm() {
		return term;
	}


	public void setTerm(int term) {
		this.term = term;
	}


	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
	
	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLesson() {
		return lesson;
	}

	public void setLesson(String lesson) {
		this.lesson = lesson;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
}
