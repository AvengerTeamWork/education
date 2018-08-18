package com.avenger.edu.teac.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.avenger.edu.teac.model.CourseTable;
import com.avenger.edu.teac.model.Grade;
import com.avenger.edu.teac.model.Grade1;
import com.avenger.edu.teac.model.Notice;
import com.avenger.edu.teac.model.ReStudy;
import com.avenger.edu.teac.model.Student;
import com.avenger.edu.teac.model.Teacher;
import com.avenger.edu.teac.serviceimp.TeacherService;

@Controller
@RequestMapping("/teacher/v1")
public class TeacherController {

	@Autowired
	TeacherService service;
	
	@GetMapping("/notice")
	@ResponseBody
	public Notice[] findNotice() {
		return this.service.findNotice();
	}
	
	/**
	 * 查找指定id的教师
	 * @param id
	 * @return
	 */
	@GetMapping("/findOne")
	@ResponseBody
	public Teacher findOne(HttpServletRequest req) {
		Cookie[] cookies = req.getCookies();
		String id = null;
		for(Cookie c:cookies) {
			if("teacherId".equals(c.getName())) {
				id = c.getValue();
			}
		}
		return this.service.findOne(Integer.parseInt(id));
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
	public void changePwd(@RequestParam(value="password") String pwd,@RequestParam int id) {
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
	public Teacher login(@RequestParam int id,@RequestParam String pwd,HttpServletResponse resp) {
		if(id==0||pwd==null||"".equals(pwd)) {
			return null;
		}
		Cookie cookie = new Cookie("teacherId", String.valueOf(id));
		resp.addCookie(cookie);
		return this.service.adminTeac(id, pwd);
	}
	
	/**
	 * 录入学生必修成绩
	 * @param gra
	 * @return
	 */
	@PostMapping("/score1")
	@ResponseBody
	public String resultInput(@RequestBody Grade gra) {
		
		int stu=this.service.findStuId(gra.getStuId());
		int tea=this.service.findTeaId(gra.getTeaId());
		int score=gra.getScore();
		if(stu==1&&tea==1&&score>=0&&score<=100) {
			this.service.resultInput(gra);
			return "成功录入学生必修成绩";
		}
		return "录入成绩失败，学号或科目号不存在或者分数不是在0~100之间的整数";
	}
	
	/**
	 * 录入学生选修成绩
	 * @param gra
	 * @return
	 */
	@PostMapping("/score2")
	@ResponseBody
	public String resultInput2(@RequestBody Grade1 gra) {
		this.service.resultInput2(gra);
		return "成功录入学生选修成绩";
	}
	
	/**
	 * 查看指定id的教师的课表
	 * @param id
	 * @return
	 */
	@GetMapping("/table")
	@ResponseBody
	public List<CourseTable> findTable(HttpServletRequest req){
		Cookie[] cookies = req.getCookies();
		String id = null;
		for(Cookie c:cookies) {
			if("teacherId".equals(c.getName())) {
				id = c.getValue();
			}
		}
		return this.service.findTable(Integer.parseInt(id));
	}
	
	/**
	 * 查找重修学生
	 * @return
	 */
	@GetMapping("/re_study")
	@ResponseBody
	public List<ReStudy> query(){
		return this.service.queryStudent();
	}
	
	/**
	 * 查找指定id的重修学生
	 * @param id
	 * @return
	 */
	@GetMapping("/re_study/{id}")
	@ResponseBody
	public ReStudy queryOne(@PathVariable int id) {
		return this.service.queryOne(id);
	}
	
}
