package com.avenger.edu.common;

/**
 * 课程类
 * @author zc
 * 2018年8月4日15:57:18
 */
public class Course {

	private int id;
	private String name;
	private String nature;
	private int credit;
	
	public Course() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}
	
}
