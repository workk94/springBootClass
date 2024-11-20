package com.acorn.mysqlTest;

import lombok.Data;

import java.util.Date;

@Data
public class Member {
    int id;
    String name;
    String email;
    Date registration_date;
}
