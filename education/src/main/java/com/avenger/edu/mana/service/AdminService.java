package com.avenger.edu.mana.service;

import com.avenger.edu.mana.model.Admin;
import com.avenger.edu.mana.model.Student;
import com.avenger.edu.mana.model.Teacher;

public interface AdminService {
	/**
	 * 登录
	 * @param id
	 * @param password
	 * @return
	 */
	public Admin login(int id,String password);
	/**
	 * 注册新生
	 * 返回学生信息
	 */
	public Student insertInformation();
	
	/**
	 * 删除某人信息
	 * @param id
	 */
	public void deleteInformation(int id);
	
	/**
	 * 修改某人信息
	 */
	public  void alterInformation();
	
	/**
	 * 查找某学生信息
	 * @param id
	 */
	public Student selectInformation(int id);
	
	/**
	 * 插入老师信息 
	 * @return
	 */
	public Teacher insertTeacher();
	
	/**
	 * 删除老师信息
	 * @param id
	 */
	public void deleteTeacher(int id);

	// 修改老师信息
	public void alterTeacher();

	// 查找老师信息
	public Teacher selectTeacher(String name);
	
	
	// 编写课表（学生课表）

	// 编写课表（老师课表）
	
}
