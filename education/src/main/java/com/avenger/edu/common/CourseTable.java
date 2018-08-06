package com.avenger.edu.common;

/**
 * 教师课表
 * @author zc
 * 2018年8月4日12:04:03
 */
public class CourseTable {

	private int id;
	private Clazz clazz;
	private Subject sub;
	private Teacher teac;
	
	public CourseTable() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Clazz getClazz() {
		return clazz;
	}

	public void setClazz(Clazz clazz) {
		this.clazz = clazz;
	}

	public Subject getSub() {
		return sub;
	}

	public void setSub(Subject sub) {
		this.sub = sub;
	}

	public Teacher getTeac() {
		return teac;
	}

	public void setTeac(Teacher teac) {
		this.teac = teac;
	}
	
}
