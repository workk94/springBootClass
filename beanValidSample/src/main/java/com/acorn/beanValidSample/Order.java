package com.acorn.beanValidSample;


import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class Order {

    @NotBlank
    String code;
    
    
    @NotBlank(message =  "상품이름  입력해 주세요")
    String name;



    @NotNull
    @Max(999)
    Integer qty ;

    @NotNull
    @Range(min=1000 , max=10000)
    Integer  price ;
    Integer  amount ;


}
