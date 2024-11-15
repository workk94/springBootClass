package com.acorn.publicData.여행;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class TravleController {


    @Autowired
    TravelWarningService  service;



    @ResponseBody
    @GetMapping("/travleInfo")
    public Map<String,Object> getData() throws Exception {
        return  service.travelInfo();
    }
}
