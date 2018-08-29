package com.avenger.edu.teac.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import com.avenger.edu.teac.model.TeacTable;
import com.avenger.edu.teac.model.Teacher;
import com.avenger.edu.teac.serviceimp.TeacherService;

@Controller
@RequestMapping("/teacher/v1")
public class TeacherController {

	@Autowired
	TeacherService service;
	
	@GetMapping("/findMajorName")
	@ResponseBody
	public String[] findMajorName() {
		return this.service.findMajorName();
	}
	
	@GetMapping("/findGradeNum")
	@ResponseBody
	public String[] findGradeNum() {
		return this.service.findGradeNum();
	}
	
	@PostMapping("/teacTable")
	@ResponseBody
	public TeacTable[] findTable(@RequestBody TeacTable t) {
		String v1=t.getGradeNum();
		int v2=t.getTerm();
		String v3=t.getMajor();
		return this.service.findTeacTable(v1, v2, v3);
	}
	
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
	@GetMapping("/change")
	@ResponseBody
	public String changePwd(@RequestParam(value="pwd1") String pwd1,@RequestParam("pwd2")String pwd2,@RequestParam("id") int id) {
		
		if(pwd1==null||pwd2==null) {
			return "密码修改失败，密码不能为空";
		}else if("".equals(pwd1)||"".equals(pwd2)){
			return "密码修改失败，密码不能为空";
		}else if(!pwd1.equals(pwd2)) {
			return "密码修改失败，两次输入的密码不一致";
		}else {
			this.service.changePwd(pwd1, id);
			return "密码修改成功";
		}
		
	}
	
	/**
	 * 登录
	 * @param id
	 * @param pwd
	 * @return
	 */
	@GetMapping("/login")
	@ResponseBody
	public Teacher login(@RequestParam int id,@RequestParam String pwd,HttpServletResponse resp,HttpServletRequest req) {
		if(id==0||pwd==null||"".equals(pwd)) {
			return null;
		}
		Cookie cookie = new Cookie("teacherId", String.valueOf(id));
		resp.addCookie(cookie);
		Teacher teacher = this.service.adminTeac(id, pwd);
		HttpSession session = req.getSession();
		session.setAttribute("teacher", teacher);
		return teacher;
	}
	
	@GetMapping("/exit")
	@ResponseBody
	public String exit(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.setAttribute("teacher", null);
		return "退出登录";
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
	 * 查找指定id的重修学生
	 * @param id
	 * @return
	 */
	@GetMapping("/re_study/{off}")
	@ResponseBody
	public ReStudy[] queryStudy(HttpServletRequest req,@PathVariable int off) {
		
		Cookie[] cookies = req.getCookies();
		String id=null;
		for(Cookie c:cookies) {
			if("teacherId".equals(c.getName())) {
				id=c.getValue();
			}
		}
		return this.service.queryStudy(Integer.parseInt(id),off);
	}
	
	@GetMapping("/getLength")
	@ResponseBody
	public int getLength(HttpServletRequest req) {
		
		Cookie[] cookies = req.getCookies();
		String id=null;
		for(Cookie c:cookies) {
			if("teacherId".equals(c.getName())) {
				id=c.getValue();
			}
		}
		return this.service.getLength(Integer.parseInt(id));
	}
	
}
