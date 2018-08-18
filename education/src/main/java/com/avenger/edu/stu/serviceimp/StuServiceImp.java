package com.avenger.edu.stu.serviceimp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseCookie;
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
		if (stuMapper.findStudentId(s.getStuId()) == 0) {
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
		if (time.equals("")) {
			time = "第一学期";
		}
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
		if (time.equals("")) {
			time = "第一学期";
		}
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
	public List<MajoCourInfo> getMajorCourse(int id, String time) {
		if (time.equals("")) {
			time = "第一学期";
		}
		String major = stuMapper.findStudentById(id).getStuMajor();
		return stuMapper.findMajorCourseByTime(major, time);
	}

	@Override
	public List<SeleCourInfo> getAllSelectCourse(String time) {
		if (time.equals("")) {
			time = "第一学期";
		}
		return stuMapper.findSelectCourse(time);
	}

	@Override
	public List<SeleCourInfo> getSelectCourse(int id, String time) {
		if (time.equals("")) {
			time = "第一学期";
		}
		return stuMapper.findSelectCourseByTime(id, time);
	}

	@Override
	public List<MainCourInfo> getMainCourse(int id, String time) {
		if (time.equals("")) {
			time = "第一学期";
		}
		return stuMapper.findMainCourseByTime(id, time);
	}

	@Override
	public List<Grade> getGrade(int id, String time) {
		if (time.equals("")) {
			return stuMapper.findGradeById(id);
		}
		return stuMapper.findGradeByTime(id, time);
	}

	@Override
	public List<Grade> getFailCourse(int id) {
		List<Grade> fail = stuMapper.findFailCourse(id);
		List<Grade> over = stuMapper.findFailCourseOver(id);
		List<Grade> again = new ArrayList<>();
		for (int i = 0; i < fail.size(); i++) {
			again.add(fail.get(i));
		}
		for (int j = 0; j < over.size(); j++) {
			again.add(over.get(j));
		}
		return again;
	}

	@Override
	public List<String> getAgainCourse(int id) {
		List<Grade> fail = stuMapper.findFailCourse(id);
		List<Grade> over = stuMapper.findFailCourseOver(id);
		List<String> again = new ArrayList<>();
		int k = 0;
		for (int i = 0; i < fail.size(); i++) {
			for (int j = 0; j < over.size(); j++) {
				if (fail.get(i).getCourName().equals(over.get(j).getCourName())) {
					k = 1;
					break;
				}
			}
			if (k == 0) {
				again.add(fail.get(i).getCourName());
			}
			k = 0;
		}
		return again;
	}

	@Override
	public List<Schedule> getSchedule(int id, String time, int week, int day) {
		if (week == 0 & day == 0 & time.equals("")) {
			return stuMapper.findScheduleById(id);
		} else if (week == 0 & day == 0) {
			return stuMapper.findScheduleByTime(id, time);
		} else if (day == 0) {
			return stuMapper.findScheduleByTimeWeek(id, time, week);
		}
		return stuMapper.findSchedule(id, time, week, day);
	}

}
