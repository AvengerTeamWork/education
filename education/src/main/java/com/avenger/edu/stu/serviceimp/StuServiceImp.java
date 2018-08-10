package com.avenger.edu.stu.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avenger.edu.stu.mapper.StuMapper;
import com.avenger.edu.stu.model.Grade;
import com.avenger.edu.stu.model.MainCourInfo;
import com.avenger.edu.stu.model.MajoCourInfo;
import com.avenger.edu.stu.model.PoinScor;
import com.avenger.edu.stu.model.Rank;
import com.avenger.edu.stu.model.Schedule;
import com.avenger.edu.stu.model.SeleCourInfo;
import com.avenger.edu.stu.model.Student;
import com.avenger.edu.stu.service.StuService;

@Service
public class StuServiceImp implements StuService {

	@Autowired
	StuMapper stuMapper;

	@Override
	public int login(Student s) {
		if (stuMapper.findStudentId(s.getStuId()) != s.getStuId()) {
			// 用户名不存在
			return 0;
		} else if (!s.getStuPassword().equals(stuMapper.findPassWordById(s.getStuId()))) {
			// 密码不匹配
			return 1;
		} else {
			// 登录成功
			return 2;
		}

	}

	@Override
	public boolean changePassWord(int id, String prePW, String NewPW) {
		if (prePW.equals(stuMapper.findPassWordById(id))) {
			// 修改成功
			stuMapper.updateStudentById(id, NewPW);
			return true;
		} else {
			// 原密码错误
			return false;
		}
	}

	@Override
	public Student getStudentInfo(int id) {
		return stuMapper.findStudentById(id);
	}

	@Override
	public Rank getClassRank(int id, String time) {
		int clasId = stuMapper.findClassByid(id);
		int rank = 0;
		Rank r = null;
		List<PoinScor> rankList = stuMapper.findClassRank(clasId, time);
		for (int i = 0; i < rankList.size(); i++) {
			if (rankList.get(i).getStuId() == id) {
				rank = i + 1;
				r = new Rank();
				r.setRank(rank);
				r.setSubTime(rankList.get(i).getSubTime());
				r.setSum(rankList.get(i).getSum());
				r.setPeriod(rankList.get(i).getPeriod());
				break;
			}
		}
		return r;
	}

	@Override
	public Rank getMajorRank(int id, String time) {
		int majoId = stuMapper.findMajorByid(id);
		int clasId = stuMapper.findClassByid(id);
		int period = stuMapper.findPeriodByClassId(clasId);
		int rank = 0;
		Rank r = null;
		List<PoinScor> rankList = stuMapper.findMajorRank(majoId, time, period);
		for (int i = 0; i < rankList.size(); i++) {
			if (rankList.get(i).getStuId() == id) {
				rank = i + 1;
				r = new Rank();
				r.setRank(rank);
				r.setSubTime(rankList.get(i).getSubTime());
				r.setSum(rankList.get(i).getSum());
				r.setPeriod(rankList.get(i).getPeriod());
				break;
			}
		}
		return r;
	}

	@Override
	public List<MajoCourInfo> getMajorCourse(String major, String time) {
		return stuMapper.findMajorCourseByTime(major, time);
	}

	@Override
	public List<SeleCourInfo> getAllSelectCourse(String time) {
		return stuMapper.findSelectCourse(time);
	}

	@Override
	public List<SeleCourInfo> getSelectCourse(int id) {
		return stuMapper.findSelectCourseById(id);
	}

	@Override
	public List<SeleCourInfo> getSelectCourseByTime(int id, String time) {
		return stuMapper.findSelectCourseByTime(id, time);
	}

	@Override
	public List<MainCourInfo> getMainCourse(int id) {
		return stuMapper.findMainCourseById(id);
	}

	@Override
	public List<MainCourInfo> getMainCourseByTime(int id, String time) {
		return stuMapper.findMainCourseByTime(id, time);
	}

	@Override
	public List<Schedule> getSchedule(int id) {
		return stuMapper.findScheduleById(id);
	}

	@Override
	public List<Schedule> getScheduleByTime(int id, String time) {
		return stuMapper.findScheduleByTime(id, time);
	}

	@Override
	public List<Grade> getGrade(int id) {
		return stuMapper.findGradeById(id);
	}

	@Override
	public List<Grade> getGradeByTime(int id, String time) {
		return stuMapper.findGradeByTime(id, time);
	}

	@Override
	public List<Grade> getFailCourse(int id) {
		return stuMapper.findFailCourse(id);
	}

}
