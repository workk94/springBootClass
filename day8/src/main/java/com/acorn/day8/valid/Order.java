package com.acorn.day8.valid;


import lombok.Data;

// 주문정보

@Data
public class Order {
    String name;
    Integer price;
    Integer qty;
}
