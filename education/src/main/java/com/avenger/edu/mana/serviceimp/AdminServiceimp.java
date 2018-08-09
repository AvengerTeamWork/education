package com.avenger.edu.mana.serviceimp;

import com.avenger.edu.mana.mapper.AdminMapper;
import com.avenger.edu.mana.model.Admin;
import com.avenger.edu.mana.model.Student;
import com.avenger.edu.mana.model.Teacher;
import com.avenger.edu.mana.service.AdminService;

public class AdminServiceimp  implements AdminService{
	AdminMapper mapper;
	
	@Override
	public Admin login(int id, String password) {
		return this.mapper.login(id, password);
	}
	@Override
	public Student insertInformation() {
		return mapper.insertInformation();
	}

	@Override
	public void deleteInformation(int id) {
		mapper.deleteInformation(id);
	}

	@Override
	public void alterInformation() {
		mapper.alterInformation();
	}

	@Override
	public Student selectInformation(int id) {
		return mapper.selectInformation(id);
	}

	@Override
	public Teacher insertTeacher() {
		return mapper.insertTeacher();
	}

	@Override
	public void deleteTeacher(int id) {
		mapper.deleteInformation(id);
	}

	@Override
	public void alterTeacher() {
		mapper.alterTeacher();
		
	}

	@Override
	public Teacher selectTeacher(String name) {
		return mapper.selectTeacher(name);
		
	}

	

}
