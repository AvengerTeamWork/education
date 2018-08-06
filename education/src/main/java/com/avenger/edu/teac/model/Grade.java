package com.avenger.edu.teac.model;

/**
 * 必修成绩类
 * @author zc
 * 2018年8月6日09:35:38
 */
public class Grade {

	private int id;
	private Student stu;
	private Subject sub;
	private int score;
	private int point;
	private String judge;
	
	public Grade() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student getStu() {
		return stu;
	}

	public void setStu(Student stu) {
		this.stu = stu;
	}

	public Subject getSub() {
		return sub;
	}

	public void setSub(Subject sub) {
		this.sub = sub;
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
