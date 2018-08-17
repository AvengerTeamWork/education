package com.avenger.edu.mana.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.avenger.edu.mana.mapper.ManagerMapper;
import com.avenger.edu.mana.model.Manager;
import com.avenger.edu.mana.model.Student;
import com.avenger.edu.mana.model.Teacher;

@Controller
@RequestMapping("/manager")
public class ManagerController {
	
	@Autowired
	ManagerMapper mmaper;
	
	@PostMapping("/login")
	@ResponseBody
	public Manager login(@RequestBody Manager manager) {
		return mmaper.login(manager);
	}
	
	@PostMapping("/registers")
	@ResponseBody
	public void registerS(@RequestBody Student student) {
		mmaper.registerStudent(student);
	}
	
	@PostMapping("/alters")
	@ResponseBody
	public void updateS(@RequestBody Student student) {
		mmaper.alterStudent(student);
	}
	
	@PostMapping("/selects")
	@ResponseBody
	public void selectT(@RequestBody Student student) {
		mmaper.selectStudent(student);
	}
	
	@PostMapping("/registert")
	@ResponseBody
	public void registerT(@RequestBody Teacher teacher) {
		mmaper.registerTeacher(teacher);;
	}
	
	@PostMapping("/altert")
	@ResponseBody
	public void updateS(@RequestBody Teacher teacher) {
		mmaper.alterTeacher(teacher);;
	}
	
	@PostMapping("/selectt")
	@ResponseBody
	public void selectS(@RequestBody Teacher teacher) {
		mmaper.selectTeacher(teacher);
	}

}
