package com.acorn.day2Batis;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class OrderRepository {

    @Autowired
    private SqlSession session;
    private String namespace = "b.";

    public List<Map<String, String>> selectAll(){
        return session.selectList(namespace + "selectAll");
    }
}
