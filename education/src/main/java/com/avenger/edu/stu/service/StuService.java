package com.avenger.edu.stu.service;

public interface StuService {

	/**
	 * 修改密码
	 * 
	 * @param id
	 * @param prePW
	 * @param NewPw
	 * @return
	 */
	public void changePW(int id, String prePW, String NewPW);

	/**
	 * 获得班级排名
	 * 
	 * @param id
	 * @param time
	 * @return
	 */
	public int getClaRank(int id, String time);

	/**
	 * 获得专业排名
	 * 
	 * @param id
	 * @param time
	 * @return
	 */
	public int getMajoRank(int id, String time);
}
