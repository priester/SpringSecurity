package com.commu.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.commu.dao.MesDao;
import com.commu.model.Message;

@Service
public class MesService {
	@Autowired
	private MesDao mesDao;
	
	public void sendMes(Message message) throws SQLException {
		mesDao.sendMes(message);
	}
	
	public List<Message> getMes(String toname) throws SQLException {
		List<Message> messages = mesDao.getMes(toname);
		return messages;
	}
	
	public int xcount(Message message) throws SQLException{
		int count = mesDao.xcount(message);
		return count;
	}
}
