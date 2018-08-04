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

	@Select(value = { "select * from teacher where teac_id=#{id}" })
	public Teacher findOne(int id);
	
	@Select(value = {"select * from teacher"})
	public List<Teacher> findAll();
	
	@Update(value = {"update teacher set teac_password=#{pwd} where teac_id=#{id}"})
	public void changePwd(String pwd,int id);
	
	@Select(value = {"select * from teacher where teac_id=#{id} and teac_password=#{pwd}"})
	public Teacher adminTeac(int id,String pwd);

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
	
	@Select(value = {"select * from restudy"})
	public List<Student> queryStudent();
	
	@Select(value = {"select * from restudy where stu_id=#{id}"})
	public Student queryOne(int id);
}
