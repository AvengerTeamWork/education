package com.avenger.edu.mana.model;

import java.util.ArrayList;
import java.util.List;

public class Teacher {
	private int teac_id;//教职工号
	private String teac_name;//姓名
	private String teac_sex;//性别
	private String teac_password;//密码
	private String teac_addr;//地址
	private String teac_email;//邮箱
	private String teac_phone;//电话
	private String teac_pic;//头像
	private int col_id;//学院
	private String col_name;
	private String teac_title;
	private String teac_time;
	
	private List<Course> courseList;
	
	
	
	public String getCol_name() {
		return col_name;
	}

	public void setCol_name(String col_name) {
		this.col_name = col_name;
	}

	public Teacher() {
		courseList=new ArrayList<>();
	}

	public int getTeac_id() {
		return teac_id;
	}

	public void setTeac_id(int teac_id) {
		this.teac_id = teac_id;
	}

	public String getTeac_name() {
		return teac_name;
	}

	public void setTeac_name(String teac_name) {
		this.teac_name = teac_name;
	}

	public String getTeac_sex() {
		return teac_sex;
	}

	public void setTeac_sex(String teac_sex) {
		this.teac_sex = teac_sex;
	}

	public String getTeac_password() {
		return teac_password;
	}

	public void setTeac_password(String teac_password) {
		this.teac_password = teac_password;
	}

	public String getTeac_addr() {
		return teac_addr;
	}

	public void setTeac_addr(String teac_addr) {
		this.teac_addr = teac_addr;
	}

	public String getTeac_email() {
		return teac_email;
	}

	public void setTeac_email(String teac_email) {
		this.teac_email = teac_email;
	}

	public String getTeac_phone() {
		return teac_phone;
	}

	public void setTeac_phone(String teac_phone) {
		this.teac_phone = teac_phone;
	}

	public String getTeac_pic() {
		return teac_pic;
	}

	public void setTeac_pic(String teac_pic) {
		this.teac_pic = teac_pic;
	}

	public int getCol_id() {
		return col_id;
	}

	public void setCol_id(int col_id) {
		this.col_id = col_id;
	}

	public String getTeac_title() {
		return teac_title;
	}

	public void setTeac_title(String teac_title) {
		this.teac_title = teac_title;
	}

	public String getTeac_time() {
		return teac_time;
	}

	public void setTeac_time(String teac_time) {
		this.teac_time = teac_time;
	}

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}
	
	
	
}
