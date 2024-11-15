package com.acorn.mapPrj;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MapController {


    @GetMapping("/mapApi")
    public String map(){
        return "mapView";
    }



    @GetMapping("/mapApi2")
    public String map2(){
        return "mapView2";
    }


    @GetMapping("/mapApi3")
    public String map3(){

        return  "mapView3";
    }


    @GetMapping("/mapApi4")
    public String map4( Model model){



        Map<String, String> position1 = new HashMap<String, String>();
        position1.put("title", "카카오2");
        position1.put("la", "33.450705");
        position1.put("lg", "126.570677");



        Map<String, String> position2 = new HashMap<String, String>();
        position2.put("title", "생태연못2");
        position2.put("la", "33.450879");
        position2.put("lg", "126.569940");

        ArrayList< Map<String, String>> list = new ArrayList< Map<String, String>> ();
        list.add(position1);
        list.add(position2);


        System.out.println( list);
        model.addAttribute("positions", list);   // 자바객체로 모델로 넘김

        return  "mapView4";
    }
}
