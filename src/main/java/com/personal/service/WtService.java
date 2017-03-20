package com.personal.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.dao.WtDao;
import com.personal.model.WorkTime;

@Service
public class WtService {
	@Autowired
	private WtDao wtDao;
	
	public void addWt(WorkTime workTime) throws SQLException{
		wtDao.addwt(workTime);
	}
	
	public List<WorkTime> querydate(HashMap<String,Object> hashMap) throws SQLException{
		List<WorkTime> workTimes = wtDao.querydate(hashMap);
		return workTimes;
	}
}
