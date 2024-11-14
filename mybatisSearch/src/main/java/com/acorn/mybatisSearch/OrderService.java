package com.acorn.mybatisSearch;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderService {
	
	
	@Autowired
	OrderRepository  repository;
	
	
	
	public List<Map<String, String>>  getOrderList() throws Exception{
		return repository.selectAll();
		
	}

	
}
