package com.avenger.edu.stu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.avenger.edu.stu.model.Rank;
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
	public int login(Student s) {
		return stuServiceimp.login(s);
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

	@PostMapping("/uppw")
	@ResponseBody
	public boolean updatePassWord(int id, String prePW, String NewPW) {
		return stuServiceimp.changePassWord(id, prePW, NewPW);
	}

	/**
	 * time学期下的班级排名
	 * @param id
	 * @param time
	 * @return
	 */
	@GetMapping("/classRank")
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
	@GetMapping("/majorRank")
	@ResponseBody
	public Rank majorRank(int id, String time) {
		return stuServiceimp.getMajorRank(id, time);
	}

}
