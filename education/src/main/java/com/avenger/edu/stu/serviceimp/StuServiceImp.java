package com.avenger.edu.stu.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avenger.edu.stu.mapper.StuMapper;
import com.avenger.edu.stu.model.PoinScor;
import com.avenger.edu.stu.model.Rank;
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
	public Rank getClaRank(int id, String time) {
		int clasId = stuMapper.getClasByid(id);
		int rank = 0;
		Rank r = null;
		List<PoinScor> rankList = stuMapper.getClasRank(clasId, time);
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
	public Rank getMajoRank(int id, String time) {
		int majoId = stuMapper.getMajoByid(id);
		int clasId = stuMapper.getClasByid(id);
		int period = stuMapper.getperiod(clasId);
		int rank = 0;
		Rank r = null;
		List<PoinScor> rankList = stuMapper.getMajoRank(majoId, time, period);
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

}
