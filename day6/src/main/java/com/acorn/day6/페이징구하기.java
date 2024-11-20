package com.acorn.day6;

public class 페이징구하기 {
    public static void main(String[] args) {
        //현재 페이지 : 2
        //글의 목록 수 : 5
        //총 레코드 수 : 100
        //그룹의 사이즈 : 5

        // 총페이지 수 :
        // 현재 그룹구하기 : 현재페이지를 기준으로 현재 그룹을 구한다 식) 현재 페이지 / 그룹의 사이즈 (나머지가 있으면 + 1)
        // 현재 그룹의 시작번호
        // 현재 그룹의 마지막번호

        // 1    2   3   4   5   => 1그룹 => 1, 5
        // 6    7   8   9   10  => 2그룹 => 6, 10
        // 11   12  13  14  15  => 3그룹 => 11, 15


        // 현재 페이지가 5이면 1그룹
        // 현재 그룹의 끝 : 현재그룹 * 그룹의 사이즈
        // 현재 그룹의 시작 : (현재그룹 - 1) * 그룹의 사이즈 + 1

        int currentPage = 6;
        int pageSize = 5;
        int totRecords = 100; // 쿼리로 얻어오기
        int grpSize = 5;

        int totalPage;
        int currentGrp;
        int grpStartPage;
        int grpEndPage;

        // 총페이지 수 구하기
        int remain = totRecords % pageSize;
        if (remain == 0) {
            totalPage = totRecords / pageSize;
        } else {
            totalPage = totRecords / pageSize + 1;
        }

        System.out.println("총 페이지 : " + totalPage);

        // 현재그룹구하기(현재 페이지에 대한)
        // 현재페이지 / 그룹의 사이즈

        // 현재 그룹
        int remain2 = currentPage % grpSize;
        if (remain2 == 0) {
            currentGrp = currentPage / grpSize;
        } else {
            currentGrp = currentPage / grpSize + 1;
        }

        System.out.println("현재 그룹 : " + currentGrp);

        // 현재그룹의 시작번호
        // 현재그룹의 마지막번호

        grpStartPage = (currentGrp - 1) * grpSize + 1;
        grpEndPage = currentGrp * grpSize;

        // 현재그룹의 마지막번호가 전체 페이지수보다 크다면 현재그룹의 마지막번호가 전체페이지수로 바뀌어야 한다

        if (grpEndPage > totalPage){
           grpEndPage = totalPage;
        }

        System.out.println(grpStartPage);
        System.out.println(grpEndPage);
    }
}
