package com.example.msproduct.dto;

import com.example.msproduct.entities.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto extends BaseEntity {

    private String name ;
    private  int quantity ;

    private StockDto stock  ;



}
