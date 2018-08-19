package com.avenger.edu.teac.model;

public class Address {

	private int id;
	private int day;
	private int week;
	private int week2;
	private String part;
	private String site;
	
	public Address() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}
	
	public int getWeek2() {
		return week2;
	}

	public void setWeek2(int week2) {
		this.week2 = week2;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}
	
}
