package com.avenger.edu.teac.model;

/**
 * 专业
 * @author zc
 * 2018年8月4日15:58:20
 */
public class Major {

	private int id;
	private String name;
	private College coll;
	private String year;
	
	public Major() {
		
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

	public College getColl() {
		return coll;
	}

	public void setColl(College coll) {
		this.coll = coll;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
}
