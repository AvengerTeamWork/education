package com.avenger.edu.stu.serviceimp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avenger.edu.stu.mapper.StuMapper;
import com.avenger.edu.stu.model.Grade;
import com.avenger.edu.stu.model.MainCourInfo;
import com.avenger.edu.stu.model.MajoCourInfo;
import com.avenger.edu.stu.model.PoinScor;
import com.avenger.edu.stu.model.Rank;
import com.avenger.edu.stu.model.Sche;
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
	public List<Sche> getSchedule(int id, String time, int week) {

		List<Schedule> scheduleList = stuMapper.findScheduleByTimeWeek(id, time, week);
		List<Sche> scheList = new ArrayList<>();
		Sche sche1 = new Sche();
		Sche sche2 = new Sche();
		Sche sche3 = new Sche();
		Sche sche4 = new Sche();
		Sche sche5 = new Sche();


		for (Schedule schedule : scheduleList) {
			switch (schedule.getPart()) {
			case "1-2":
				switch (schedule.getDay()) {
				case 1:
					sche1.setMonday(schedule.getCourName());
					break;
				case 2:
					sche1.setTuesday(schedule.getCourName());
					break;
				case 3:
					sche1.setWednesday(schedule.getCourName());
					break;
				case 4:
					sche1.setThursday(schedule.getCourName());
					break;
				case 5:
					sche1.setFriday(schedule.getCourName());
					break;
				case 6:
					sche1.setSaturday(schedule.getCourName());
					break;
				case 7:
					sche1.setSunday(schedule.getCourName());
					break;
				}

				break;
			case "3-4":
				switch (schedule.getDay()) {
				case 1:
					sche2.setMonday(schedule.getCourName());
					break;
				case 2:
					sche2.setTuesday(schedule.getCourName());
					break;
				case 3:
					sche2.setWednesday(schedule.getCourName());
					break;
				case 4:
					sche2.setThursday(schedule.getCourName());
					break;
				case 5:
					sche2.setFriday(schedule.getCourName());
					break;
				case 6:
					sche2.setSaturday(schedule.getCourName());
					break;
				case 7:
					sche2.setSunday(schedule.getCourName());
					break;
				}
				
				break;
			case "5-6":
				switch (schedule.getDay()) {
				case 1:
					sche3.setMonday(schedule.getCourName());
					break;
				case 2:
					sche3.setTuesday(schedule.getCourName());
					break;
				case 3:
					sche3.setWednesday(schedule.getCourName());
					break;
				case 4:
					sche3.setThursday(schedule.getCourName());
					break;
				case 5:
					sche3.setFriday(schedule.getCourName());
					break;
				case 6:
					sche3.setSaturday(schedule.getCourName());
					break;
				case 7:
					sche3.setSunday(schedule.getCourName());
					break;
				}
				
				break;
			case "7-8":
				switch (schedule.getDay()) {
				case 1:
					sche4.setMonday(schedule.getCourName());
					break;
				case 2:
					sche4.setTuesday(schedule.getCourName());
					break;
				case 3:
					sche4.setWednesday(schedule.getCourName());
					break;
				case 4:
					sche4.setThursday(schedule.getCourName());
					break;
				case 5:
					sche4.setFriday(schedule.getCourName());
					break;
				case 6:
					sche4.setSaturday(schedule.getCourName());
					break;
				case 7:
					sche4.setSunday(schedule.getCourName());
					break;
				}
		
				break;
			case "9-10":
				switch (schedule.getDay()) {
				case 1:
					sche5.setMonday(schedule.getCourName());
					break;
				case 2:
					sche5.setTuesday(schedule.getCourName());
					break;
				case 3:
					sche5.setWednesday(schedule.getCourName());
					break;
				case 4:
					sche5.setThursday(schedule.getCourName());
					break;
				case 5:
					sche5.setFriday(schedule.getCourName());
					break;
				case 6:
					sche5.setSaturday(schedule.getCourName());
					break;
				case 7:
					sche5.setSunday(schedule.getCourName());
					break;
				}
				
				break;
			}
		}
		sche1.setPart("1-2");
		sche2.setPart("3-4");
		sche3.setPart("5-6");
		sche4.setPart("7-8");
		sche5.setPart("9-10");
			scheList.add(sche1);
			scheList.add(sche2);
			scheList.add(sche3);
			scheList.add(sche4);
			scheList.add(sche5);
			
			return scheList;
	}
	
	@Override
	public Schedule getScheduleInfo(int id, String time, int week,int day,String part) {
		return stuMapper.findScheduleBy(id, time, week, day, part);
	}
		
}
