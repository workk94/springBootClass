package com.acorn.day6;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemberRepository {
    @Autowired
    private SqlSession session;

    public List<Member> selectAllPage(int currentPage , int pageSize) {

        // 현재 페이지
        // 글의 목록 수
        // 1 -> 1 ~ 2
        // 2 -> 3 ~ 4

        int start = (currentPage -1) * pageSize + 1;
        int end = currentPage * pageSize;

        Map<String, Integer> pageInfo = new HashMap<>();
        pageInfo.put("start", start);
        pageInfo.put("end", end);
        List<Member > list =  session.selectList( "a.selectAllPage", pageInfo);
        return list;
    }

    public int countAll() {
        int totalCount = session.selectOne("a.selectCount");
        return totalCount;
    }

}
