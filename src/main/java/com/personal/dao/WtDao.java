package com.personal.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.base.dao.BaseDao;
import com.personal.model.WorkTime;

@Component
public class WtDao extends BaseDao{
	
	//(打卡)添加工作时间
	public void addwt(WorkTime workTime) throws SQLException {
		sqlMapClient.insert("addWorkTime",workTime);
	}
	
	public List<WorkTime> querydate(HashMap<String,Object> hashMap) throws SQLException{
		@SuppressWarnings("unchecked")
		List<WorkTime> worktimes = sqlMapClient.queryForList("querydate", hashMap);
		return worktimes;
	}
}
