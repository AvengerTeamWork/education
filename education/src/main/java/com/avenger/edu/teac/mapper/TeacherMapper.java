package com.avenger.edu.teac.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.avenger.edu.teac.model.CourseTable;
import com.avenger.edu.teac.model.Student;
import com.avenger.edu.teac.model.Teacher;

@Mapper
public interface TeacherMapper {

	@Select(value = { "select * from teacher where id=#{id}" })
	public Teacher findOne(int id);
	
	@Select(value = {"select * from teacher"})
	public List<Teacher> findAll();
	
	@Update(value = {"update teacher set teac_password=#{pwd} where id=#{id}"})
	public void changePwd(String pwd,int id);
	
	/**
	 * 登录
	 * @param 教师编号
	 * @param 教师密码
	 * @return
	 */
	public boolean adminTeac(int id,String pwd);

	/**
	 * 找回密码
	 * @param 教师编号
	 * @param 身份证后六位
	 * @return
	 */
	//public boolean findPwd(int id,String card);
	
	/**
	 * 录入必修成绩
	 */
	public void resultInput();
	
	/**
	 * 录入选修成绩
	 */
	public void resultInput2();
	
	/**
	 * 查看教师课表
	 * @return
	 */
	public List<CourseTable> findTable();
	
	/**
	 * 查找所有重修的学生
	 * @return
	 */
	public List<Student> queryStudent();
	
	/**
	 * 根据id查找某个重修的学生
	 * @param id
	 * @return
	 */
	public Student queryOne(int id);
}
