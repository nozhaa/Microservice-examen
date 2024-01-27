package com.example.msproduct.controller;

import com.example.msproduct.dto.ProductDto;
import com.example.msproduct.entity.Product;
import com.example.msproduct.service.ProductService;
import com.example.msproduct.generic.RestControllerGeneric;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class ProductController extends RestControllerGeneric<Product, Long> {

    private final ProductService productService ;

    @GetMapping(name="/hello")
    public String sayHello(){
        return "hello from product";
    }

    @GetMapping("productStock/{id}")
    public ProductDto findProcductWithStock(@PathVariable("id") Long id) {

        return productService.getProductWithStock(id);
    }






}
