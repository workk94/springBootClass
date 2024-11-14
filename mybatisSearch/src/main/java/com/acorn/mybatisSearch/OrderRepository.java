package com.acorn.mybatisSearch;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class OrderRepository {
	 @Autowired
	    private SqlSession session;
	    private static String namespace = "com.acorn.OrderMapper.";


	    
	    public List<Map<String, String>> selectAll() throws Exception {
	        return session.selectList(namespace+"selectAll");
	    } // List<E> selectList(String statement)
	

}
