package com.avenger.edu.stu.model;

/**
 * 选修课程
 * @author YiXin
 *
 */
public class SeleCourInfo {
	private int scId;
	private String scCourName;
	private String scTeacName;
	private int scCourCredit;
	private String scCourNature;
	private int scCourPeriod;
	private String scTeacTitle;

	public String getScCourNature() {
		return scCourNature;
	}

	public void setScCourNature(String scCourNature) {
		this.scCourNature = scCourNature;
	}

	public int getScId() {
		return scId;
	}

	public void setScId(int scId) {
		this.scId = scId;
	}

	public String getScCourName() {
		return scCourName;
	}

	public void setScCourName(String scCourName) {
		this.scCourName = scCourName;
	}

	public String getScTeacName() {
		return scTeacName;
	}

	public void setScTeacName(String scTeacName) {
		this.scTeacName = scTeacName;
	}

	public int getScCourCredit() {
		return scCourCredit;
	}

	public void setScCourCredit(int scCourCredit) {
		this.scCourCredit = scCourCredit;
	}

	public int getScCourPeriod() {
		return scCourPeriod;
	}

	public void setScCourPeriod(int scCourPeriod) {
		this.scCourPeriod = scCourPeriod;
	}

	public String getScTeacTitle() {
		return scTeacTitle;
	}

	public void setScTeacTitle(String scTeacTitle) {
		this.scTeacTitle = scTeacTitle;
	}

}
