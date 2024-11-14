package com.example.mybatisSqlsession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MemberService2 {

    @Autowired
    MemberRepository2 repository;


    public List<Member> getMembers(){
        return repository.findAll();

    }


}
