package com.avenger.edu.stu.model;

/**
 * 班级类
 * @author zc
 * 2018年8月4日15:59:41
 */
public class Clazz {

	private int id;
	private String name;
	private String period;
	private Major major;
	
	public Clazz() {
		
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

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}
	
}
