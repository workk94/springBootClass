package com.acorn.day6;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    String m_id;
    String m_pw;
    String m_name;
    String m_tel;
    String m_birthday;
    int m_point;
    String m_grade;
}
