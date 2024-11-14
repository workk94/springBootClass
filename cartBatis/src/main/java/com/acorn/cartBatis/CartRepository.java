package com.acorn.cartBatis;

 

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 

@Repository
public class CartRepository {
    @Autowired
    private SqlSession session;
    private static String namespace = "acorn.CartMapper.";


 
    //고객id를 입력으로 받아 장바구니 정보를 list로 반환    
    public List<CartDTO> selectCart(String id) throws Exception {
        return session.selectList(namespace+"selectCart" , id);
    } // List<E> selectList(String statement)


   
    // 장바구니 정보를 입력으로 받아  장바구니 상품정보를  list 반환
    public List<GoodsDTO> selectGoods( List<CartDTO> list) throws Exception {
        return session.selectList(namespace+"selectGoods" , list);
    } // List<E> selectList(String statement)
  
   

}
 