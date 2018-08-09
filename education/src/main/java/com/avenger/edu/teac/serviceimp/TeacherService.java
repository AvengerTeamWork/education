package com.avenger.edu.teac.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avenger.edu.teac.mapper.TeacherMapper;
import com.avenger.edu.teac.model.CourseTable;
import com.avenger.edu.teac.model.Grade;
import com.avenger.edu.teac.model.Grade1;
import com.avenger.edu.teac.model.Student;
import com.avenger.edu.teac.model.Teacher;
import com.avenger.edu.teac.service.TeacService;

@Service
public class TeacherService implements TeacService{

	@Autowired
	TeacherMapper mapper;
	
	@Override
	public Teacher findOne(int id) {
		
		return this.mapper.findOne(id);
	}

	@Override
	public List<Teacher> findAll() {
		return this.mapper.findAll();
	}

	@Override
	public void changePwd(String pwd,int id) {

		this.mapper.changePwd(pwd, id);
	}

	@Override
	public Teacher adminTeac(int id, String pwd) {

		return this.mapper.adminTeac(id, pwd);
	}
	
	@Override
	public void resultInput(Grade gra) {

		this.mapper.resultInput(gra);
	}

	@Override
	public void resultInput2(Grade1 gra) {

		this.mapper.resultInput2(gra);
	}

	@Override
	public List<CourseTable> findTable(int id) {
		return this.mapper.findTable(id);
	}

	@Override
	public List<Student> queryStudent() {
		return this.mapper.queryStudent();
	}

	@Override
	public Student queryOne(int id) {
		return this.mapper.queryOne(id);
	}
	
}
