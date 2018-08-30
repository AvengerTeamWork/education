package com.avenger.edu.mana.model;

import java.util.ArrayList;
import java.util.List;

import com.avenger.edu.teac.model.Clazz;
import com.avenger.edu.teac.model.Major;

public class Student {
	private int stu_id;//学号
	private String stu_name;//姓名
	private String stu_sex;//性别
	private String stu_password;//登陆密码
	private String stu_addr;//住址
	private String stu_phone;//联系电话
	private String stu_email;//邮箱
	private String stu_pic;//头像
	private int clas_id;
	private int majo_id;
	private String stu_majo;
	private String stu_clas;
	private String stu_col;
	
	private List<Grade> gradeList;
	private List<Course> courseList;
	
	
	
	

	public Student() {
		gradeList=new ArrayList<>();
		courseList=new ArrayList<>();
	}

	public List<Grade> getGradeList() {
		return gradeList;
	}

	public void setGradeList(List<Grade> gradeList) {
		this.gradeList = gradeList;
	}

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	public int getStu_id() {
		return stu_id;
	}

	public void setStu_id(int stu_id) {
		this.stu_id = stu_id;
	}

	public String getStu_name() {
		return stu_name;
	}

	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}

	public String getStu_sex() {
		return stu_sex;
	}

	public void setStu_sex(String stu_sex) {
		this.stu_sex = stu_sex;
	}

	public String getStu_password() {
		return stu_password;
	}

	public void setStu_password(String stu_password) {
		this.stu_password = stu_password;
	}

	public String getStu_addr() {
		return stu_addr;
	}

	public void setStu_addr(String stu_addr) {
		this.stu_addr = stu_addr;
	}

	public String getStu_phone() {
		return stu_phone;
	}

	public void setStu_phone(String stu_phone) {
		this.stu_phone = stu_phone;
	}

	public String getStu_email() {
		return stu_email;
	}

	public void setStu_email(String stu_email) {
		this.stu_email = stu_email;
	}

	public String getStu_pic() {
		return stu_pic;
	}

	public void setStu_pic(String stu_pic) {
		this.stu_pic = stu_pic;
	}

	public int getClas_id() {
		return clas_id;
	}

	public void setClas_id(int clas_id) {
		this.clas_id = clas_id;
	}

	public int getMajo_id() {
		return majo_id;
	}

	public void setMajo_id(int majo_id) {
		this.majo_id = majo_id;
	}

	public String getStu_majo() {
		return stu_majo;
	}

	public void setStu_majo(String stu_majo) {
		this.stu_majo = stu_majo;
	}

	public String getStu_clas() {
		return stu_clas;
	}

	public void setStu_clas(String stu_clas) {
		this.stu_clas = stu_clas;
	}

	public String getStu_col() {
		return stu_col;
	}

	public void setStu_col(String stu_col) {
		this.stu_col = stu_col;
	}



	
	
}
