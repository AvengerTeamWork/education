package com.avenger.edu.stu.service;

import com.avenger.edu.stu.model.Rank;
import com.avenger.edu.stu.model.Student;

public interface StuService {

	/**
	 * 登录
	 * 
	 * @param Student
	 * @return
	 */
	public int login(Student s);

	/**
	 * 获得学号为Id的学生个人信息
	 * 
	 * @param id
	 * @return
	 */
	public Student getStudentInfo(int id);

	/**
	 * 修改密码
	 * 
	 * @param id
	 * @param prePW
	 * @param NewPw
	 * @return
	 */
	public boolean changePassWord(int id, String prePW, String NewPW);

	/**
	 * 获得班级排名
	 * 
	 * @param id
	 * @param time
	 * @return
	 */
	public Rank getClassRank(int id, String time);

	/**
	 * 获得专业排名
	 * 
	 * @param id
	 * @param time
	 * @return
	 */
	public Rank getMajorRank(int id, String time);
}
