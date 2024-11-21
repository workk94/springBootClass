package com.acorn.validSample;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.util.Date;


@Slf4j
@Controller
public class MemberController {


    @InitBinder
    public void toDate( WebDataBinder binder) {
			/*
			 *  • 해당 Controller로 들어오는 요청에 대해
				• 추가적인 설정을 하고 싶을 때 사용할 수 있다.
				• 모든 요청 전에InitBinder를 선언한 메소드가 실행된다.
			 */
        //데이터변환시 날짜데이터변환  String  -> Date
        //변환
       // SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
       // binder.registerCustomEditor( Date.class , new CustomDateEditor( df, false)) ;

        binder.registerCustomEditor(String[].class,   new StringArrayPropertyEditor("#"));
        //binder.registerCustomEditor(String[].class, "hobby", new StringArrayPropertyEditor("#"));

    }

    @GetMapping("/member")
    public String memberForm( Member member){

        return "member";

    }




    @PostMapping("/member")
    // public String member(Member member  ,BindingResult result){
     public String member(Member member  ,BindingResult result){

        log.info( "err={}", result);

        log.info( "member={}", member);
        //에러가 있는 경우 에러 정보를 확이할 수 있다
        //BindingResult가 있으면 오류발생시 예외가 터지지 않는다  (바인딩 오류시 )
        //오류에 대한 적절한 처리를 할수 있다
        return "member";

    }
}
