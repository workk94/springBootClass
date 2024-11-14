package com.acorn.day2Batis;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {

    @Autowired
    private SqlSession session;
    private String namespace = "a.";

    //전체조회하기
    public List<Member> selectAll() {
        return session.selectList(namespace + "selectAll");
    }

    // 추가
    public int insert(Member member){
        return session.insert(namespace + "insert", member);
    }



}
