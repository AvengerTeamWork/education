package com.avenger.edu.stu.model;

/**
 * 成绩
 * 
 * @author YiXin
 *
 */
public class Grade {
	private String stuId;
	private String courName;
	private int courCredit;
	private String courNature;
	private String teacName;
	private String subTime;
	private int score;
	private int point;
	private String judge;

	public String getSubTime() {
		return subTime;
	}

	public void setSubTime(String subTime) {
		this.subTime = subTime;
	}

	public String getStuId() {
		return stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

	public String getCourName() {
		return courName;
	}

	public void setCourName(String courName) {
		this.courName = courName;
	}

	public int getCourCredit() {
		return courCredit;
	}

	public void setCourCredit(int courCredit) {
		this.courCredit = courCredit;
	}

	public String getCourNature() {
		return courNature;
	}

	public void setCourNature(String courNature) {
		this.courNature = courNature;
	}

	public String getTeacName() {
		return teacName;
	}

	public void setTeacName(String teacName) {
		this.teacName = teacName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getJudge() {
		return judge;
	}

	public void setJudge(String judge) {
		this.judge = judge;
	}

}
