package com.acorn.day8_valid;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Data
public class Order {

    @NotBlank
    String name;

    @NotNull
    @Range(min = 100, max = 10000)
    Integer price;

    @NotNull
    @Range(max = 999)
    Integer qty;
}
