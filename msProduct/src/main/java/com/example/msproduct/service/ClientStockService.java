package com.example.msproduct.service;


import com.example.msproduct.dto.StockDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "stock-service")
public interface ClientStockService {



    @GetMapping(value = "/stock/api/{id}")
    public StockDto getStock(@PathVariable("id") Long id );







}
