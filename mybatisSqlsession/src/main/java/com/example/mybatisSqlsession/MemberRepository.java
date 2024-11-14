package com.example.mybatisSqlsession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class MemberRepository {

    @Autowired
    private SqlSession sqlSession;

    public List<Member> findAll() {
        return sqlSession.selectList("com.example.demo.mapper.MemberMapper.SelectAll");
    }



    public int  insert( Member member) {

        sqlSession.insert("com.example.demo.mapper.MemberMapper.insert" , member);

        return 1;
    }









}
