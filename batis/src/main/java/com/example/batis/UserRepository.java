package com.example.batis;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {


    @Autowired
    SqlSession  session;

    public List<User> selectAll() throws  Exception{


      return   session.selectList( "com.example.demo.mapper.UserMapper.SelectAll");
    }
}
