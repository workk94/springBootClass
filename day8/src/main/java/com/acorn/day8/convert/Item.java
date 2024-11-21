package com.acorn.day8.convert;

import lombok.Data;

import java.util.Date;

@Data
public class Item {
    Integer su;
    Date birth;
    String name;
    String[] hobby; // 산책#독서#영화보기
}
