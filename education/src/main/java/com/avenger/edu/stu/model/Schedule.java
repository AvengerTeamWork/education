package com.avenger.edu.stu.model;

/**
 * 课表
 * @author YiXin
 *
 */
public class Schedule {

	private String courName;
	private String teacName;
	private String subTime;
	private int day;
	private int week;
	private String part;
	private String site;

	
	public String getSubTime() {
		return subTime;
	}

	public void setSubTime(String subTime) {
		this.subTime = subTime;
	}

	public String getCourName() {
		return courName;
	}

	public void setCourName(String courName) {
		this.courName = courName;
	}

	public String getTeacName() {
		return teacName;
	}

	public void setTeacName(String teacName) {
		this.teacName = teacName;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}



	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

}
