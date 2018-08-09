package com.avenger.edu.stu.service;

import com.avenger.edu.stu.model.Rank;

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
	public Rank getClaRank(int id, String time);

	/**
	 * 获得专业排名
	 * 
	 * @param id
	 * @param time
	 * @return
	 */
	public Rank getMajoRank(int id, String time);
}
