package com.avenger.edu.stu.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.avenger.edu.stu.model.Grade;
import com.avenger.edu.stu.model.MainCourInfo;
import com.avenger.edu.stu.model.MajoCourInfo;
import com.avenger.edu.stu.model.Rank;
import com.avenger.edu.stu.model.Schedule;
import com.avenger.edu.stu.model.SeleCourInfo;
import com.avenger.edu.stu.model.Student;
import com.avenger.edu.stu.serviceimp.StuServiceImp;

@Controller
@RequestMapping("/stu")
public class StuController {

	@Autowired
	StuServiceImp stuServiceimp;

	/**
	 * 登录
	 * 
	 * @param s
	 * @return
	 */
	@PostMapping
	@ResponseBody
	public int login(@RequestBody Student s, HttpServletResponse resp) {
		int i = stuServiceimp.login(s);
		if(i==2) {
			Cookie stuId = new Cookie("id", String.valueOf(s.getStuId()));
			resp.addCookie(stuId);
		}
		return i;
	}
	
	/**
	 * 获得cookie值
	 * @param req
	 * @return
	 */
	@GetMapping
	@ResponseBody
	public String student(HttpServletRequest req) {
		Cookie[] c = req.getCookies();
		String str = null;
		for (int i = 0; i < c.length; i++) {
			if("id".equals(c[i].getName())) {
				str = c[i].getValue();
				System.out.println( c[i].getValue());
				System.out.println(str);
			}
		}
		return str;

	}

	/**
	 * 获得个人信息
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	@ResponseBody
	public Student studentInfo(@PathVariable int id) {
		return stuServiceimp.getStudentInfo(id);

	}

	/**
	 * 修改密码
	 * 
	 * @param id
	 * @param prePW
	 * @param NewPW
	 * @return
	 */
	@PostMapping("/uppw")
	@ResponseBody
	public boolean updatePassWord(int id, String prePW, String NewPW) {
		return stuServiceimp.changePassWord(id, prePW, NewPW);
	}

	/**
	 * 专业的必修课程
	 * 
	 * @param major
	 * @param time
	 * @return
	 */
	@PostMapping("/majorCourse")
	@ResponseBody
	public List<MajoCourInfo> majorCourse(String major, String time) {
		return stuServiceimp.getMajorCourse(major, time);
	}

	/**
	 * 可选修的课程
	 * 
	 * @param time
	 * @return
	 */
	@PostMapping("/allSelectCourse")
	@ResponseBody
	public List<SeleCourInfo> allSelectCourse(String time) {
		return stuServiceimp.getAllSelectCourse(time);
	}

	/**
	 * 学生的选修课程信息
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/selectCourse/{id}")
	@ResponseBody
	public List<SeleCourInfo> selectCourse(@PathVariable int id) {
		return stuServiceimp.getSelectCourse(id);
	}

	/**
	 * 学生在time学期的选修课程信息
	 * 
	 * @param id
	 * @param time
	 * @return
	 */
	@PostMapping("/selectCourseByTime")
	@ResponseBody
	public List<SeleCourInfo> selectCourseByTime(int id, String time) {
		return stuServiceimp.getSelectCourseByTime(id, time);
	}

	/**
	 * 学生的主修课程信息
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/mainCourse/{id}")
	@ResponseBody
	public List<MainCourInfo> mainCourse(@PathVariable int id) {
		return stuServiceimp.getMainCourse(id);
	}

	/**
	 * 学生在time学期的主修课程信息
	 * 
	 * @param id
	 * @param time
	 * @return
	 */
	@PostMapping("/mainCourseByTime")
	@ResponseBody
	public List<MainCourInfo> mainCourseByTime(int id, String time) {
		return stuServiceimp.getMainCourseByTime(id, time);
	}

	/**
	 * 学生的课表信息
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/schedule/{id}")
	@ResponseBody
	public List<Schedule> schedule(@PathVariable int id) {
		return stuServiceimp.getSchedule(id);
	}

	/**
	 * 学生在time学期的课表信息
	 * 
	 * @param id
	 * @param time
	 * @return
	 */
	@PostMapping("/scheduleByTime")
	@ResponseBody
	public List<Schedule> scheduleByTime(int id, String time) {
		return stuServiceimp.getScheduleByTime(id, time);
	}

	/**
	 * 学生的成绩信息
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/grade/{id}")
	@ResponseBody
	public List<Grade> grade(@PathVariable int id) {
		return stuServiceimp.getGrade(id);
	}

	/**
	 * 学生在time学期下的成绩信息
	 * 
	 * @param id
	 * @param time
	 * @return
	 */
	@PostMapping("/gradeByTime")
	@ResponseBody
	public List<Grade> gradeByTime(int id, String time) {
		return stuServiceimp.getGradeByTime(id, time);
	}

	/**
	 * time学期下的班级排名
	 * 
	 * @param id
	 * @param time
	 * @return
	 */
	@PostMapping("/classRank")
	@ResponseBody
	public Rank classRank(int id, String time) {
		return stuServiceimp.getClassRank(id, time);
	}

	/**
	 * time学期下的专业排名
	 * 
	 * @param id
	 * @param time
	 * @return
	 */
	@PostMapping("/majorRank")
	@ResponseBody
	public Rank majorRank(int id, String time) {
		return stuServiceimp.getMajorRank(id, time);
	}

	/**
	 * 学生的挂科情况
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/failCourse/{id}")
	@ResponseBody
	public List<Grade> failCourse(@PathVariable int id) {
		return stuServiceimp.getFailCourse(id);
	}
	
	/**
	 * 学生需要重修的课程
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/againCourse/{id}")
	@ResponseBody
	public List<String> againCourse(@PathVariable int id) {
		return stuServiceimp.getAgainCourse(id);
	}

}
