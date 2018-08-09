package com.avenger.edu.stu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.avenger.edu.stu.mapper.StuMapper;
import com.avenger.edu.stu.model.Rank;
import com.avenger.edu.stu.model.Student;
import com.avenger.edu.stu.serviceimp.StuServiceImp;

@Controller
@RequestMapping("/stu")
public class StuController {

	@Autowired
	StuMapper stuMapper;
	@Autowired
	StuServiceImp ssi;

	/**
	 * 登录
	 * 
	 * @param s
	 * @return
	 */
	@PostMapping
	@ResponseBody
	public Student login(Student s) {
		Student student = null;
		student = stuMapper.login(s);
		return student;
	}

	/**
	 * 获得个人信息
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	@ResponseBody
	public Student loadStuInfo(@PathVariable int id) {
		return stuMapper.load(id);

	}

	@GetMapping("/claRank")
	@ResponseBody
	public Rank getClaRank(int id, String time) {
		return ssi.getClaRank(id, time);
	}

	@GetMapping("/majoRank")
	@ResponseBody
	public Rank getMajoRank(int id, String time) {
		return ssi.getMajoRank(id, time);
	}

}
