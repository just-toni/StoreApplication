package com.ecommerce.store.data;

import com.ecommerce.store.data.model.Currency;
import lombok.Data;

@Data
public class ProductDto {

    private String name;
    private String details;
    private Double price;
    private Currency currency;

}
