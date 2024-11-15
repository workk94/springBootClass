package com.acorn.day4;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MapController {

    //지도 서비스
    @GetMapping("/map1")
    public String map1() {
        return "map1View";
    }


    @GetMapping("/map2")
    public String map2() {
        return "map2View";
    }

    @GetMapping("/map3")
    public String map3() {
        return "map3View";
    }

    @GetMapping("/map4")
    public String map4(Model model) {

/*
        {
            title: '카카오',
                    latlng: new kakao.maps.LatLng(33.450705, 126.570677)
        },
        {
            title: '생태연못',
                    latlng: new kakao.maps.LatLng(33.450936, 126.569477)
        },
        {
            title: '텃밭',
                    latlng: new kakao.maps.LatLng(33.450879, 126.569940)
        },
        {
            title: '근린공원',
                    latlng: new kakao.maps.LatLng(33.451393, 126.570738)
        }
*/
        //ArrayList - Item (title, lat, lng)

        Map<String, String> item = new HashMap<>(); // title, la, lg
        item.put("title", "카카오2");
        item.put("la", "33.450705");
        item.put("lg", "126.570677");

        Map<String, String> item2 = new HashMap<>(); // title, la, lg
        item2.put("title", "생태연못2");
        item2.put("la", "33.450936");
        item2.put("lg", "126.569477");

        ArrayList<Map<String, String>> list = new ArrayList<>();
        list.add(item);
        list.add(item2);

        model.addAttribute("positions", list);

        return "map4View";
    }

}
