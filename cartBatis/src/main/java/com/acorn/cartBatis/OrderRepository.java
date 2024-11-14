package com.acorn.cartBatis;

 

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 

@Repository
public class OrderRepository {
    @Autowired
    private SqlSession session;
    private static String namespace = "acorn.OrderMapper.";

     
    
    public int insert(OrderDTO dto) throws Exception {
        return session.insert(namespace+"insertNewOrder", dto);
    }  

    
     
}
 