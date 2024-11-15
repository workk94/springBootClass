package com.acorn.day3;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {

    @Autowired
    private SqlSession session;

    // 전체 조회
    public List<Member> selectAll(){
        return session.selectList("a.selectAll");
    }

    public List<Member> searchSelect (List<String> list){
        return  session.selectList("a.searchSelect", list);
    }

}
