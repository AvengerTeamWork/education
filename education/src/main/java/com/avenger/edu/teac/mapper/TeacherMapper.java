package com.avenger.edu.teac.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.avenger.edu.teac.model.Clazz;
import com.avenger.edu.teac.model.College;
import com.avenger.edu.teac.model.CourseTable;
import com.avenger.edu.teac.model.Grade;
import com.avenger.edu.teac.model.Grade1;
import com.avenger.edu.teac.model.Major;
import com.avenger.edu.teac.model.Student;
import com.avenger.edu.teac.model.Subject;
import com.avenger.edu.teac.model.Teacher;

@Mapper
public interface TeacherMapper {

	@Select(value = { "select * from teacher where teac_id=#{id}" })
	@Results(value = {
			@Result(property="id",column="teac_id"),
			@Result(property="name",column="teac_name"),
			@Result(property="sex",column="teac_sex"),
			@Result(property="password",column="teac_password"),
			@Result(property="address",column="teac_addr"),
			@Result(property="phone",column="teac_phone"),
			@Result(property="email",column="teac_email"),
			@Result(property="pic",column="teac_pic"),
			@Result(property="col",column="col_id",javaType=College.class,one=@One(select="loadCollegeById"))
	})
	public Teacher findOne(int id);
	
	@Select(value = {"select * from teacher"})
	@Results(value = {
			@Result(property="id",column="teac_id"),
			@Result(property="name",column="teac_name"),
			@Result(property="sex",column="teac_sex"),
			@Result(property="password",column="teac_password"),
			@Result(property="address",column="teac_addr"),
			@Result(property="phone",column="teac_phone"),
			@Result(property="email",column="teac_email"),
			@Result(property="pic",column="teac_pic"),
			@Result(property="col",column="col_id",javaType=College.class,one=@One(select="loadCollegeById"))
	})
	public List<Teacher> findAll();
	
	@Select(value = {"select * from college where col_id=#{id}"})
	@Results(value = {
			@Result(property="id",column="col_id"),
			@Result(property="name",column="col_name"),
			@Result(property="president",column="col_president"),
			@Result(property="phone",column="col_phone")
	})
	public College loadCollegeById(int id);
	
	
	@Update(value = {"update teacher set teac_password=#{pwd} where teac_id=#{id}"})
	public void changePwd(String pwd,int id);
	
	
	@Select(value = {"select * from teacher where teac_id=#{id} and teac_password=#{pwd}"})
	@Results(value = {
			@Result(property="id",column="teac_id"),
			@Result(property="name",column="teac_name"),
			@Result(property="sex",column="teac_sex"),
			@Result(property="password",column="teac_password"),
			@Result(property="address",column="teac_addr"),
			@Result(property="phone",column="teac_phone"),
			@Result(property="email",column="teac_email"),
			@Result(property="pic",column="teac_pic"),
			@Result(property="col",column="col_id",javaType=College.class,one=@One(select="loadCollegeById"))
	})
	public Teacher adminTeac(int id,String pwd);

	
	@Insert(value = {"insert into grade(stu_id,tea_id,gra_score,gra_point,gra_judge) values(#{stu.id},#{sub.id},#{score},#{point},#{judge})"})
	public void resultInput(Grade gra);
	
	
	@Insert(value = {"insert into grade1(stu_id,sele_id,gra1_score,gra1_point,gra1_judge) values(#{stu.id}),#{selec.id},#{score},#{point},#{judge}"})
	public void resultInput2(Grade1 gra);
	
	
	@Select(value = {"select * from teaching where teac_id=#{id}"})
	@Results(value = {
			@Result(property="id",column="tea_id"),
			@Result(property="clazz",column="cla_id",javaType=Clazz.class,many = @Many(select="loadClazzById")),
			@Result(property="sub",column="sub_id",javaType=Subject.class,many = @Many(select="loadSubjectById")),
			@Result(property="teac",column="teac_id",javaType=Teacher.class,many = @Many(select="loadTeacherById"))
	})
	public List<CourseTable> findTable(int id);
	
	@Select(value = {"select * from clazz where id=#{id}"})
	@Results(value = {
			@Result(property="id",column="clas_id"),
			@Result(property="name",column="clas_name"),
			@Result(property="period",column="clas_period"),
			@Result(property="major",column="majo_id",javaType=Major.class,one = @One(select="loadMajorById"))
	})
	public Clazz loadClazzById(int id);
	
	@Select(value = {"select * from major where id = #{id}"})
	@Results(value = {
			@Result(property="id",column="majo_id"),
			@Result(property="name",column="majo_name"),
			@Result(property="year",column="majo_year"),
			@Result(property="coll",column="col_id",javaType=College.class,one = @One(select="loadCollegeById"))
	})
	public Major loadMajorById(int id);
	
	
	@Select(value = {"select * from re_study"})
	@Results(value = {
			@Result(property="id",column="teac_id"),
			@Result(property="name",column="teac_name"),
			@Result(property="sex",column="teac_sex"),
			@Result(property="password",column="teac_password"),
			@Result(property="address",column="teac_addr"),
			@Result(property="phone",column="teac_phone"),
			@Result(property="email",column="teac_email"),
			@Result(property="pic",column="teac_pic"),
			@Result(property="clazz",column="clas_id",javaType=Clazz.class,one=@One(select="loadClazzById")),
			@Result(property="major",column="majo_id",javaType=Major.class,one=@One(select="loadMajorById"))
			})
	public List<Student> queryStudent();
	
	@Select(value = {"select * from re_study where stu_id=#{id}"})
	@Results(value = {
			@Result(property="id",column="teac_id"),
			@Result(property="name",column="teac_name"),
			@Result(property="sex",column="teac_sex"),
			@Result(property="password",column="teac_password"),
			@Result(property="address",column="teac_addr"),
			@Result(property="phone",column="teac_phone"),
			@Result(property="email",column="teac_email"),
			@Result(property="pic",column="teac_pic"),
			@Result(property="clazz",column="clas_id",javaType=Clazz.class,one=@One(select="loadClazzById")),
			@Result(property="major",column="majo_id",javaType=Major.class,one=@One(select="loadMajorById"))
			})
	public Student queryOne(int id);
}
