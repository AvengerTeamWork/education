package com.avenger.edu.stu.model;

/**
 * 主修课程
 * 
 * @author YiXin
 *
 */
public class MainCourInfo {
	private String mcCourName;
	private String mcTeacName;
	private int mcCourCredit;
	private String mcCourNature;
	private String mcSubTime;
	private int mcCourPeriod;
	private String mcTeacTitle;

	public String getMcSubTime() {
		return mcSubTime;
	}

	public void setMcSubTime(String mcSubTime) {
		this.mcSubTime = mcSubTime;
	}

	public String getMcCourNature() {
		return mcCourNature;
	}

	public void setMcCourNature(String mcCourNature) {
		this.mcCourNature = mcCourNature;
	}

	public String getMcCourName() {
		return mcCourName;
	}

	public void setMcCourName(String mcCourName) {
		this.mcCourName = mcCourName;
	}

	public String getMcTeacName() {
		return mcTeacName;
	}

	public void setMcTeacName(String mcTeacName) {
		this.mcTeacName = mcTeacName;
	}

	public int getMcCourCredit() {
		return mcCourCredit;
	}

	public void setMcCourCredit(int mcCourCredit) {
		this.mcCourCredit = mcCourCredit;
	}

	public int getMcCourPeriod() {
		return mcCourPeriod;
	}

	public void setMcCourPeriod(int mcCourPeriod) {
		this.mcCourPeriod = mcCourPeriod;
	}

	public String getMcTeacTitle() {
		return mcTeacTitle;
	}

	public void setMcTeacTitle(String mcTeacTitle) {
		this.mcTeacTitle = mcTeacTitle;
	}

}
