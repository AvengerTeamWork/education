package com.avenger.edu.stu.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avenger.edu.stu.mapper.StuMapper;
import com.avenger.edu.stu.model.PoinScor;
import com.avenger.edu.stu.service.StuService;

@Service
public class StuServiceImp implements StuService {

	@Autowired
	StuMapper stuMapper;

	@Override
	public void changePW(int id, String prePW, String NewPW) {
		if (stuMapper.getPW(id) == prePW) {
			stuMapper.updateStuPW(id, NewPW);
		} else {
			System.out.println("原密码错误");
		}
	}

	@Override
	public int getClaRank(int id, String time) {
		int clasId = stuMapper.getClasByid(id);
		int rank = 0;
		List<PoinScor> rankList = stuMapper.getRankByclas(clasId, time);
		for (int i = 0; i < rankList.size(); i++) {
			if (rankList.get(i).getStuId() == id) {
				rank = i + 1;
				break;
			}
		}
		return rank;
	}

	@Override
	public int getMajoRank(int id, String time) {
		int majoId = stuMapper.getMajoByid(id);
		int rank = 0;
		List<PoinScor> rankList = stuMapper.getRankByclas(majoId, time);
		for (int i = 0; i < rankList.size(); i++) {
			if (rankList.get(i).getStuId() == id) {
				rank = i + 1;
				break;
			}
		}
		return rank;
	}

}
