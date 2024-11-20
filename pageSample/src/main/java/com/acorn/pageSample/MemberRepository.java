package com.acorn.pageSample;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public class MemberRepository {


	@Autowired
	SqlSession  session;



	public List<Member> selectAllPage(int currentPage, int size){



		int start= (currentPage-1)*size+1;
		int end = currentPage*size;


		System.out.println("start" + start);
		System.out.println("end" + end);
		Map<String, Integer>  pageInfo  = new HashMap<>();
		pageInfo.put("start" , start);
		pageInfo.put("end" , end);


		return session.selectList( "b.selectAllPage" ,  pageInfo);

	}

	public int  countAll(  ){
		return session.selectOne( "b.selectCount"  );

	}
}
