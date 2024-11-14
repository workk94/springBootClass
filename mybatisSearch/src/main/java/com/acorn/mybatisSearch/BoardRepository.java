package com.acorn.mybatisSearch;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/*
 
   
    CREATE TABLE boardt (
    board_no number(5)  PRIMARY KEY,
    title VARCHAR2(255),
    writer VARCHAR2(255),
    content VARCHAR2(255)
);
-- 첫 번째 게시물 삽입
INSERT INTO boardt   VALUES
(1, '프로그래밍은 뭔가요?', '차은우', '첫 번째 게시물의 내용입니다.');

-- 두 번째 게시물 삽입
INSERT INTO boardt  VALUES
(2, 'Object 클래스에 대해서 알려주세요', '이문세', '두 번째 게시물의 내용입니다.');

-- 세 번째 게시물 삽입
INSERT INTO boardt   VALUES
(3, '자바에서 참조형변수는 뭐예요 ', '박상원', '세 번째 게시물의 내용입니다.');

INSERT INTO boardt   VALUES
(4, '매서드로 만드는법 알려주세요', '공유', '4 번째 게시물의 내용입니다.');

-- 두 번째 게시물 삽입
INSERT INTO boardt  VALUES
(5, '자바 객체지향 다형성은요?', '김민우', '5 번째 게시물의 내용입니다.');

-- 세 번째 게시물 삽입
INSERT INTO boardt   VALUES
(6, ' 자바 람다식 뭐예요', '한효주', '6 번째 게시물의 내용입니다.');

commit;
   
 */
 
@Repository
public class BoardRepository {
	 @Autowired
	    private SqlSession session;
	    private static String namespace = "com.acorn.BoardMapper1.";

	  
	    
	    public List<BoardDTO> searchCondition(  SearchCondition condition) throws Exception {	    	
	    	//SearchCondition condition  = new SearchCondition();
	    	//condition.setCondition("title");
	    	//condition.setKeyword( "자바");	    	
	        return session.selectList(namespace+"getBoardList" , condition );
	        
	    } // List<E> selectList(String statement)
	
	     
	 
	     
}
