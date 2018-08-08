package com.avenger.edu.stu.model;

public class PoinScor {
	private int stuId;
	private int sum;
	private String subTime;
	private int clasId;
	private int period;
	private int majoId;

	public String getSubTime() {
		return subTime;
	}

	public void setSubTime(String subTime) {
		this.subTime = subTime;
	}

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getClasId() {
		return clasId;
	}

	public void setClasId(int clasId) {
		this.clasId = clasId;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public int getMajoId() {
		return majoId;
	}

	public void setMajoId(int majoId) {
		this.majoId = majoId;
	}

}
