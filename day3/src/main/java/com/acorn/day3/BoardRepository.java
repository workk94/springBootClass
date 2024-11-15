package com.acorn.day3;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardRepository {

    @Autowired
    private SqlSession session;

    //검색조건에 따른 게시판 결과 반환
    public List<Board> searchList(SearchCondition condition){
        return session.selectList("b.selectBoard", condition);
    }

}
