package com.avenger.edu.teac.model;

/**
 * 选修课
 * @author zc
 * 2018年8月6日11:12:56
 */
public class Selec {

	private int id;
	private Student stu;
	private Teacher teac;
	private Course cour;
	
	public Selec() {
		
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

	public Teacher getTeac() {
		return teac;
	}

	public void setTeac(Teacher teac) {
		this.teac = teac;
	}

	public Course getCour() {
		return cour;
	}

	public void setCour(Course cour) {
		this.cour = cour;
	}
	
}
