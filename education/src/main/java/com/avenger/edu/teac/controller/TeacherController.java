package com.avenger.edu.teac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.avenger.edu.teac.model.CourseTable;
import com.avenger.edu.teac.model.Grade;
import com.avenger.edu.teac.model.Grade1;
import com.avenger.edu.teac.model.Student;
import com.avenger.edu.teac.model.Teacher;
import com.avenger.edu.teac.serviceimp.TeacherService;

@Controller
@RequestMapping("/teacher/v1")
public class TeacherController {

	@Autowired
	TeacherService service;
	
	/**
	 * 查找指定id的教师
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	@ResponseBody
	public Teacher findOne(@PathVariable int id) {
		return this.service.findOne(id);
	}
	
	/**
	 * 查找所有教师
	 * @return
	 */
	@GetMapping()
	@ResponseBody
	public List<Teacher> findAll(){
		return this.service.findAll();
	}
	
	/**
	 * 修改密码
	 * @param pwd
	 * @param id
	 */
	@PutMapping("/change")
	@ResponseBody
	public void changePwd(String pwd,int id) {
		this.service.changePwd(pwd, id);
	}
	
	/**
	 * 登录
	 * @param id
	 * @param pwd
	 * @return
	 */
	@GetMapping("/login")
	@ResponseBody
	public Teacher login(int id,String pwd) {
		return this.service.adminTeac(id, pwd);
	}
	
	/**
	 * 录入学生必修成绩
	 * @param gra
	 * @return
	 */
	@PostMapping("/score1")
	@ResponseBody
	public String resultInput(Grade gra) {
		this.service.resultInput(gra);
		return "成功录入学生必修成绩";
	}
	
	/**
	 * 录入学生选修成绩
	 * @param gra
	 * @return
	 */
	@PostMapping("/score2")
	@ResponseBody
	public String resultInput2(Grade1 gra) {
		this.service.resultInput2(gra);
		return "成功录入学生选修成绩";
	}
	
	/**
	 * 查看指定id的教师的课表
	 * @param id
	 * @return
	 */
	@GetMapping("/table/{id}")
	@ResponseBody
	public List<CourseTable> findTable(@PathVariable int id){
		return this.service.findTable(id);
	}
	
	/**
	 * 查找重修学生
	 * @return
	 */
	@GetMapping("/re_study")
	@ResponseBody
	public List<Student> query(){
		return this.service.queryStudent();
	}
	
	/**
	 * 查找指定id的重修学生
	 * @param id
	 * @return
	 */
	@GetMapping("/re_study/{id}")
	@ResponseBody
	public Student queryOne(@PathVariable int id) {
		return this.service.queryOne(id);
	}
	
}
