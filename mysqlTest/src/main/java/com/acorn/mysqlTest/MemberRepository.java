package com.acorn.mysqlTest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {

    @Autowired
    private SqlSession session;


    public List<Member> selectAll(){
        return session.selectList("a.SelectAll");
    }
}
