package com.avenger.edu.mana.model;

import com.avenger.edu.mana.model.Major;

public class Clazz {
	private int id;//班级编号
	private String name;//班级名称
	private String period;//届
	private Major major;//专业
	
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
