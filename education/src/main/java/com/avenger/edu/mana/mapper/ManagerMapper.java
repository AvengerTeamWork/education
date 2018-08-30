package com.avenger.edu.mana.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.avenger.edu.mana.model.Clazz;
import com.avenger.edu.mana.model.College;
import com.avenger.edu.mana.model.Major;
import com.avenger.edu.mana.model.Manager;
import com.avenger.edu.mana.model.Student;
import com.avenger.edu.mana.model.Teacher;

@Mapper
public interface  ManagerMapper {
	
	@Select("select * from manager where mana_id=#{mana_id}")
	public Manager login(Manager manager);
	
	@Insert("insert into student(stu_id,stu_name,stu_addr,stu_phone,stu_email,clas_id,majo_id,stu_sex,stu_pic) values"
			+"(#{stu_id},#{stu_name},#{stu_addr},#{stu_phone},#{stu_email},#{clas_id},#{majo_id},#{stu_sex},#{stu_pic})")
	public void registerStudent(Student student);
	
	@Delete("delete from student where clas_id in(select clas_id from clazz where clas_period=#{clas_period} )")
	public void deleteGraduate(Clazz clazz);

	@Delete("delete from student where stu_id=#{stu_id} ")
	public void deletestudent(Clazz clazz);
	
	@Update("update student set stu_name=#{stu_name},stu_addr=#{stu_addr},stu_phone=#{stu_phone},stu_email=#{stu_email}")
	public void alterStudent(Student student);
	
	@Select("select * from v_stuinfo where stu_id=#{stu_id}")
	public Student selectStudent(Student student);
	
	@Insert("insert into teacher(teac_id,teac_name,teac_addr,teac_phone,teac_email,teac_title,teac_time,col_id,teac_sex,teac_pic) values"
			+"(#{teac_id},#{teac_name},#{teac_addr},#{teac_phone},#{teac_email},#{teac_title},#{teac_time},#{col_id},#{teac_sex},#{teac_pic})")
	public void registerTeacher(Teacher teacher);
	
	@Update("update teacher set teac_addr=#{teac_addr},teac_phone=#{teac_phone},teac_email=#{teac_email},teac_title=#{teac_title},teac_time=#{teac_time}")
	public void alterTeacher(Teacher teacher);
	
	@Select("select * from teacher where teac_id=#{teac_id}")
	public Teacher selectTeacher(Teacher teacher);
	
	@Select("select * from clazz")
	public List<Clazz> selectClazz();
	
	@Select("select * from college")
	public List<College> selectCollege();
	
	@Select("select * from major")
	public List<Major> selectMajor();
}
