package com.acorn.mybatisSearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@Controller
public class OrderController {

	
	@Autowired
    OrderService service;
	
	
	
	@GetMapping("/orderList")	
	public String  getOrderList(  Model model) throws Exception {
		List<Map<String, String>> list =service.getOrderList();
		model.addAttribute("list", list );

		System.out.println( list);
		return "orderView";
	}
	


	
}
