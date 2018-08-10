package com.avenger.edu.stu.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.avenger.edu.stu.model.Grade;
import com.avenger.edu.stu.model.MainCourInfo;
import com.avenger.edu.stu.model.MajoCourInfo;
import com.avenger.edu.stu.model.Rank;
import com.avenger.edu.stu.model.Schedule;
import com.avenger.edu.stu.model.SeleCourInfo;
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
	 * 专业的必修课程
	 * 
	 * @param major
	 * @param time
	 * @return
	 */
	public List<MajoCourInfo> getMajorCourse(String major, String time);

	/**
	 * 可选修的课程
	 * 
	 * @param time
	 * @return
	 */
	public List<SeleCourInfo> getAllSelectCourse(String time);

	/**
	 * 学生的选修课程信息
	 * 
	 * @param id
	 * @return
	 */
	public List<SeleCourInfo> getSelectCourse(int id);

	/**
	 * 学生在time学期的选修课程信息
	 * 
	 * @param id
	 * @param time
	 * @return
	 */
	public List<SeleCourInfo> getSelectCourseByTime(int id, String time);

	/**
	 * 学生的主修课程信息
	 * 
	 * @param id
	 * @return
	 */
	public List<MainCourInfo> getMainCourse(int id);

	/**
	 * 学生在time学期的主修课程信息
	 * 
	 * @param id
	 * @param time
	 * @return
	 */
	public List<MainCourInfo> getMainCourseByTime(int id, String time);

	/**
	 * 学生的课表信息
	 * 
	 * @param id
	 * @return
	 */
	public List<Schedule> getSchedule(int id);

	/**
	 * 学生在time学期的课表信息
	 * 
	 * @param id
	 * @param time
	 * @return
	 */
	public List<Schedule> getScheduleByTime(int id, String time);

	/**
	 * 学生的成绩信息
	 * 
	 * @param id
	 * @return
	 */
	public List<Grade> getGrade(int id);

	/**
	 * 学生在time学期下的成绩信息
	 * 
	 * @param id
	 * @param time
	 * @return
	 */
	public List<Grade> getGradeByTime(int id, String time);

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
	
	/**
	 * 学生的挂科情况
	 * @param id
	 * @return
	 */
	public List<Grade> getFailCourse(int id);
}
