package com.example.mybatisSqlsession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class MemberService {

    @Autowired
    MemberRepository repository;

    public List<Member> getMembers() {
        return repository.findAll();
    }


    // 트랜잭션이란?  모두 수행되거나 수행되지 않아야 하는 논리적인 하나의 단위
    // 두 개의 작업이 모두 완료되어야  성공  commit이 이루어짐
    // 한 개라도 실패하면 실패로  롤백처리됨


    @Transactional
    public int registerMember(Member member) {

        repository.insert(member);

        String s = null;
        int r = s.length();

        //  if(  s.length() >=5 )  throw new RuntimeException("5보다 크면 안됨 ");

        repository.insert(member);
        return 1;
    }


    /*

    public  void registerMember(Member member){
        repository.insert(member) ;
    }



     */

}
