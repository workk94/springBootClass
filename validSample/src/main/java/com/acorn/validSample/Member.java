package com.acorn.validSample;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Member {

    String name;

    //컨버터
    //@DateTimeFormat(pattern = "yyyy-MM-dd")  // 날짜 형식 지정
    Date birth;
    String email;
    int age;


    String[] hobby;


}
