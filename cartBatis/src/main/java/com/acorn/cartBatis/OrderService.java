package com.acorn.cartBatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {
	
	@Autowired
    OrderRepository dao;
	
	public void registerOrder( List<OrderDTO> list ) {
		
		for( OrderDTO  orderItem : list) {
			
			try {
				dao.insert(orderItem);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	 

}
