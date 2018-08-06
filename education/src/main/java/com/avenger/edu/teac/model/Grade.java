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
	private float score;
	
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

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}
	
}
