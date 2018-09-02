package com.avenger.edu.teac.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.avenger.edu.teac.model.Address;
import com.avenger.edu.teac.model.Clazz;
import com.avenger.edu.teac.model.College;
import com.avenger.edu.teac.model.Course;
import com.avenger.edu.teac.model.CourseTable;
import com.avenger.edu.teac.model.Grade;
import com.avenger.edu.teac.model.Grade1;
import com.avenger.edu.teac.model.Major;
import com.avenger.edu.teac.model.Notice;
import com.avenger.edu.teac.model.ReStudy;
import com.avenger.edu.teac.model.Student;
import com.avenger.edu.teac.model.Subject;
import com.avenger.edu.teac.model.TeacTable;
import com.avenger.edu.teac.model.Teacher;

@Mapper
public interface TeacherMapper {
	
	@Select(value = {"select count(teac_id) from teacher where teac_id=#{id}"})
	public int findTeacId(int id);
	
	@Select(value = {"select count(teac_password) from teacher where teac_password=#{pwd}"})
	public int findTeacPassword(String pwd);
	
	@Select(value = {"select distinct clas_period from clazz"})
	public String[] findGradeNum();
	
	@Select(value = {"select distinct majo_name from major"})
	public String[] findMajorName();
	
	@Select(value = {"select * from education.table where clas_period=#{gradeNum} and cour_period=#{period} and majo_name=#{major}"})
	@Results(value = {
			@Result(property="gradeNum",column="clas_period"),
			@Result(property="term",column="cour_period"),
			@Result(property="week",column="adrs_week"),
			@Result(property="day",column="adrs_day"),
			@Result(property="part",column="adrs_part"),
			@Result(property="address",column="adrs_site"),
			@Result(property="lesson",column="cour_name")
	})
	public TeacTable[] findTeacTable(@Param("gradeNum")String gradeNum,@Param("period")int period,@Param("major")String major);
	
	@Select(value = {"select count(stu_id) from student where stu_id=#{id}"})
	public int findStuId(int id);
	
	@Select(value = {"select count(tea_id) from teaching where tea_id=#{id}"})
	public int findTeaId(int id);
	
	@Select(value = {"select * from notice order by noti_id desc limit 2 offset 0"})
	@Results(value= {
			@Result(property="id",column="noti_id"),
			@Result(property="title",column="noti_title"),
			@Result(property="content",column="noti_content"),
			@Result(property="editor",column="noti_editor"),
			@Result(property="time",column="noti_time")
	})
	public Notice[] findNotice();
	
	/**
	 * 根据编号查找指定的老师
	 * @param id
	 * @return
	 */
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
			@Result(property="title",column="teac_title"),
			@Result(property="time",column="teac_time"),
			@Result(property="col",column="col_id",javaType=College.class,one=@One(select="loadCollegeById"))
	})
	public Teacher findOne(int id);
	
	/**
	 * 查找所有老师的信息
	 * @return
	 */
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
			@Result(property="title",column="teac_title"),
			@Result(property="time",column="teac_time"),
			@Result(property="col",column="col_id",javaType=College.class,one=@One(select="loadCollegeById"))
	})
	public List<Teacher> findAll();
	
	/**
	 * 通过学院编号查找学院
	 * @param id
	 * @return
	 */
	@Select(value = {"select * from college where col_id=#{id}"})
	@Results(value = {
			@Result(property="id",column="col_id"),
			@Result(property="name",column="col_name"),
			@Result(property="president",column="col_president"),
			@Result(property="phone",column="col_phone")
	})
	public College loadCollegeById(int id);
	
	/**
	 * 老师修改密码
	 * @param 新密码
	 * @param 修改密码的老师的编号
	 */
	@Update(value = {"update teacher set teac_password=#{pwd} where teac_id=#{id}"})
	public void changePwd(@Param("pwd") String pwd,@Param("id") int id);
	
	/**
	 * 教师登录
	 * @param id
	 * @param pwd
	 * @return
	 */
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
	public Teacher adminTeac(@Param("id") int id,@Param("pwd") String pwd);

	/**
	 * 录入必修成绩单
	 * @param gra
	 */
	@Insert(value = {"insert into grade(stu_id,tea_id,gra_score,gra_point,gra_judge) values(#{stuId},#{teaId},#{score},#{point},#{judge})"})
	public void resultInput(Grade gra);
	
	/**
	 * 录入选修成绩单
	 * @param gra
	 */
	@Insert(value = {"insert into grade1(stu_id,sele_id,gra1_score,gra1_point,gra1_judge) values(#{stu.id}),#{selec.id},#{score},#{point},#{judge}"})
	public void resultInput2(Grade1 gra);
	
	/**
	 * 查看教师课表
	 * @param 教师编号
	 * @return
	 */
	@Select(value = {"select * from teaching where teac_id=#{id}"})
	@Results(value = {
			@Result(property="id",column="tea_id"),
			@Result(property="clazz",column="clas_id",javaType=Clazz.class,many = @Many(select="loadClazzById")),
			@Result(property="sub",column="sub_id",javaType=Subject.class,many = @Many(select="loadSubjectById")),
			@Result(property="teac",column="teac_id",javaType=Teacher.class,many = @Many(select="findOne"))
	})
	public List<CourseTable> findTable(int id);
	
	@Select(value = {"select * from subject where sub_id=#{id}"})
	@Results(value= {
			@Result(property="id",column="sub_id"),
			@Result(property="majorId",column="majo_id"),
			@Result(property="courseId",column="cour_id"),
			@Result(property="time",column="sub_time")
	})
	public Subject loadSubjectById(int id);
	
	@Select(value = {"select * from course where cour_id=#{id}"})
	@Results(value = {
			@Result(property="id",column="cour_id"),
			@Result(property="name",column="cour_name"),
			@Result(property="nature",column="cour_nature"),
			@Result(property="credit",column="cour_credit"),
			@Result(property="period",column="cour_period"),
			@Result(property="address",column="adrs_id",javaType=Address.class,many=@Many(select="loadAddressById"))
	})
	public Course loadCourseById(int id);
	
	/**
	 * 通过班级编号查找班级
	 * @param id
	 * @return
	 */
	@Select(value = {"select * from clazz where clas_id=#{id}"})
	@Results(value = {
			@Result(property="id",column="clas_id"),
			@Result(property="name",column="clas_name"),
			@Result(property="period",column="clas_period"),
			@Result(property="major",column="majo_id",javaType=Major.class,one = @One(select="loadMajorById"))
	})
	public Clazz loadClazzById(int id);
	
	/**
	 * 通过专业编号查找专业
	 * @param id
	 * @return
	 */
	@Select(value = {"select * from major where majo_id = #{id}"})
	@Results(value = {
			@Result(property="id",column="majo_id"),
			@Result(property="name",column="majo_name"),
			@Result(property="year",column="majo_year"),
			@Result(property="coll",column="col_id",javaType=College.class,one = @One(select="loadCollegeById"))
	})
	public Major loadMajorById(int id);
	
	/**
	 * 查看指定教师的重修学生的信息
	 * @param id
	 * @return
	 */
	@Select(value = {"select * from reStudy where teac_id=#{id} order by id limit 5 offset #{off}"})
	@Results(value = {
			@Result(property="id",column="id"),
			@Result(property="student",column="stu_id",javaType=Student.class,many=@Many(select="findStudent")),
			@Result(property="teacher",column="teac_id",javaType=Teacher.class,many=@Many(select="findOne")),
			@Result(property="course",column="cour_id",javaType=Course.class,many=@Many(select="loadCourseById")),
			@Result(property="address",column="adrs_id",javaType=Address.class,many=@Many(select="loadAddressById"))
	})
	public ReStudy[] queryStudy(@Param("id") int id,@Param("off") int off);
	
	@Select(value = {"select count(*) from reStudy where teac_id=#{id}"})
	public int getLength(int id);
	
	@Select(value = {"select * from address where adrs_id=#{id}"})
	@Results(value = {
			@Result(property="id",column="adrs_id"),
			@Result(property="day",column="adrs_day"),
			@Result(property="week",column="adrs_week"),
			@Result(property="week2",column="adrs_week2"),
			@Result(property="part",column="adrs_part"),
			@Result(property="site",column="adrs_site")
	})
	public Address loadAddressById(int id);
	
	@Select(value = {"select * from student where stu_id=#{id}"})
	@Results(value = {
			@Result(property="id",column="stu_id"),
			@Result(property="name",column="stu_name"),
			@Result(property="sex",column="stu_sex"),
			@Result(property="address",column="stu_id"),
			@Result(property="phone",column="stu_addr"),
			@Result(property="address",column="stu_phone"),
			@Result(property="email",column="stu_email"),
			@Result(property="pic",column="stu_pic"),
			@Result(property="clazz",column="clas_id",javaType=Clazz.class,one=@One(select="loadClazzById")),
			@Result(property="major",column="majo_id",javaType=Major.class,one=@One(select="loadMajorById"))
	})
	public Student findStudent(int id);
}
