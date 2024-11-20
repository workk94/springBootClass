package com.acorn.day6;

public class PageHandler {

    private int currentPage;
    private int pageSize;
    private int totRecoreds;   //쿼리로 얻어오기
    private int grpSzie;

    private int totalPage;
    private int currentGrp;
    private int grpStartPage;
    private int grpEndPage;

    //기본생성자 제공하지 않겠다.

    public PageHandler(int currentPage, int pageSize, int totRecoreds, int grpSzie) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totRecoreds = totRecoreds;
        this.grpSzie = grpSzie;

        calc();
    }


    //계산하기

    private void calc(){

        int remain  = totRecoreds % pageSize ;

        if( remain==0){
            totalPage = totRecoreds/ pageSize;
        }else{
            totalPage = totRecoreds/pageSize   +1 ;
        }

        int remain2  =  currentPage  %  grpSzie;

        if( remain2 ==0){
            currentGrp = currentPage/grpSzie;
        }else{
            currentGrp = currentPage/grpSzie  +1;

        }

        grpStartPage = (currentGrp-1) *grpSzie +1;  //
        grpEndPage = currentGrp*grpSzie;   //

        if( grpEndPage  > totalPage){
            grpEndPage=totalPage;
        }

    }


    public int getCurrentPage() {
        return currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getTotRecoreds() {
        return totRecoreds;
    }

    public int getGrpSzie() {
        return grpSzie;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public int getCurrentGrp() {
        return currentGrp;
    }

    public int getGrpStartPage() {
        return grpStartPage;
    }

    public int getGrpEndPage() {
        return grpEndPage;
    }
}
