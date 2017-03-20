package com.base.dao;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;

@SuppressWarnings("deprecation")
public class BaseDao extends SqlMapClientDaoSupport {
    
    @Resource(name="sqlMapClient")  //通过bean名称注入
    protected SqlMapClient sqlMapClient;
    
    @PostConstruct  //完成sqlMapClient初始化工作
    public void initSqlMapClient(){
           super.setSqlMapClient(sqlMapClient);
    }
}
