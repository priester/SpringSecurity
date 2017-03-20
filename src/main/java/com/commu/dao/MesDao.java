package com.commu.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.base.dao.BaseDao;
import com.commu.model.Message;

@Component
public class MesDao extends BaseDao {
	
	public void sendMes(Message message) throws SQLException {
		sqlMapClient.insert("sendMes", message);
	}
	
	public List<Message> getMes(String toname) throws SQLException {
		@SuppressWarnings("unchecked")
		List<Message> messages = sqlMapClient.queryForList("getMes", toname);
		return messages;
	}
	
	public int xcount(Message message) throws SQLException{
		int count = (Integer)sqlMapClient.queryForObject("xcount",message);
		return count;
	}
}
