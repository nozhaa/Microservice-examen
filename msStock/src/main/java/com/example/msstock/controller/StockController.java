package com.example.msstock.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import com.example.msstock.entity.Stock;
import com.example.msstock.generic.RestControllerGeneric;
import com.example.msstock.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/api/")
@RestController
@RequiredArgsConstructor
public class StockController   extends RestControllerGeneric<Stock, Long> {

    private final StockService  stockService ;
}
