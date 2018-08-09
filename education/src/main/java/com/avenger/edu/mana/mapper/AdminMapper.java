package com.avenger.edu.mana.mapper;

import org.apache.ibatis.annotations.Delete;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.avenger.edu.mana.model.Admin;
import com.avenger.edu.mana.model.Student;
import com.avenger.edu.mana.model.Teacher;

public interface AdminMapper {
	//登录
	@Select("select admin_password from admin where admin_id=#{id}")
	@Results({
		@Result(column="admin_password", property="password")
	})
	public Admin login(int id,String password);
	
	
	//注册新生（插入学生信息）
	@Insert("")
	@Results({
		@Result(column="stu_id",property="id"),
		@Result(column="stu_name",property="name"),
		@Result(column="stu_password",property="password"),
		@Result(column="stu_sex",property="sex"),
		@Result(column="stu_addr",property="address"),
		@Result(column="stu_phone",property="phone"),
		@Result(column="stu_email",property="email"),
		@Result(column="stu_pic",property="pic"),
		@Result(column="clas_id",property="clazz"),
		@Result(column="major_id",property="major")	
	})
	public Student insertInformation();
	
	//删除某位学生信息
	@Delete("delete from student where stu_id=#{id}")
	public void deleteInformation(int id);
	
	//修改某位学生信息
	@Update("")
	public void alterInformation();
	
	
	//查找某人信息
	@Select("")
	@Results({
		@Result(column="stu_id",property="id"),
		@Result(column="stu_name",property="name"),
		@Result(column="stu_password",property="password"),
		@Result(column="stu_sex",property="sex"),
		@Result(column="stu_addr",property="address"),
		@Result(column="stu_phone",property="phone"),
		@Result(column="stu_email",property="email"),
		@Result(column="stu_pic",property="pic"),
		@Result(column="clas_id",property="clazz"),
		@Result(column="major_id",property="major")	
	})
	public Student selectInformation(int id);
	
	//注册老师
	@Insert("")
	@Results({
		@Result(column="teac_id",property="id"),
		@Result(column="teac_name",property="name"),
		@Result(column="teac_sex",property="sex"),
		@Result(column="teac_password",property="password"),
		@Result(column="teac_addr",property="address"),
		@Result(column="teac_phone",property="phone"),
		@Result(column="teac_email",property="email"),
		@Result(column="teac_pic",property="pic"),
		@Result(column="col_id",property="college"),
		@Result(column="teac_title",property="title"),
		@Result(column="teac_time",property="time")
	})
	public Teacher insertTeacher();
	
	//删除老师信息
	@Delete("delete from teacher where teac_id=#{id}")
	public void deleteTeacher(int id);
	
	//修改老师信息
	@Update("")
	public void alterTeacher();
	
	//查找老师信息
	@Select("")
	public Teacher selectTeacher(String name);
	
	
	
	//编写课表（学生课表）

	
	
	//编写课表（老师课表）
}
