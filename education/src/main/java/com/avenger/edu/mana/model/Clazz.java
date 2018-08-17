package com.avenger.edu.mana.model;

import com.avenger.edu.mana.model.Major;

public class Clazz {
	private int clas_id;//班级编号
	private String clas_name;//班级名称
	private String clas_period;//届
	private int majo_id;//专业
	public int getClas_id() {
		return clas_id;
	}
	public void setClas_id(int clas_id) {
		this.clas_id = clas_id;
	}
	public String getClas_name() {
		return clas_name;
	}
	public void setClas_name(String clas_name) {
		this.clas_name = clas_name;
	}
	public String getClas_period() {
		return clas_period;
	}
	public void setClas_period(String clas_period) {
		this.clas_period = clas_period;
	}
	public int getMajo_id() {
		return majo_id;
	}
	public void setMajo_id(int majo_id) {
		this.majo_id = majo_id;
	}
	
	
}
