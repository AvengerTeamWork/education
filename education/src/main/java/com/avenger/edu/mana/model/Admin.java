package com.avenger.edu.mana.model;

public class Admin {
	private int id;//管理员账号
	private String password;//管理员登录密码
	
	public Admin() {
		
	}
	public Admin(int id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
