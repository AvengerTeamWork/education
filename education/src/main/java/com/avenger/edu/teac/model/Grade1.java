package com.avenger.edu.teac.model;

/**
 * 选修成绩
 * @author zc
 * 2018年8月6日11:14:09
 */
public class Grade1 {

	private int id;
	private Student stu;
	private Selec selec;
	private int score;
	private int point;
	private String judge;
	
	public Grade1() {
		
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

	public Selec getSelec() {
		return selec;
	}

	public void setSelec(Selec selec) {
		this.selec = selec;
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
