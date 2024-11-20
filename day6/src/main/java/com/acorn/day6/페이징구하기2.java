package com.acorn.day6;


public class 페이징구하기2 {
    public static void main(String[] args) {
        PageHandler handler = new PageHandler(1, 10, 100, 5);

        int currentPage = handler.getCurrentPage();
        int currentGrp = handler.getCurrentGrp();
        int grpStartPage = handler.getGrpStartPage();
        int grpEndPage = handler.getGrpEndPage();

        System.out.println("현재페이지 " + currentPage);
        System.out.println("현재그룹 " + currentGrp);
        System.out.println("그룹시작 " + grpStartPage);
        System.out.println("그룹마지막 " + grpEndPage);
    }

}
