package com.example.mybatisSqlsession;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


//참고만 하세요
@Service
public class MemberRepository2 {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;


    public List<Member> findAll() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            return sqlSession.selectList("com.example.demo.mapper.MemberMapper.SelectAll");
        }
    }





}
