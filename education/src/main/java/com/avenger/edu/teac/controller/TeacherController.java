package com.avenger.edu.teac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.avenger.edu.teac.model.Teacher;
import com.avenger.edu.teac.serviceimp.TeacherService;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

	@Autowired
	TeacherService service;
	
	@GetMapping("/findOne")
	@ResponseBody
	public Teacher findOne(int id) {
		return this.service.findOne(id);
	}
	
}
