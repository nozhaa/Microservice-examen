package com.example.msstock.service;

import com.example.msstock.generic.ServiceGenericImpl;
import com.example.msstock.repository.StockRepository;
import com.example.msstock.entity.Stock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class StockServiceImpl extends ServiceGenericImpl<Stock, Long> implements  StockService{

    private final StockRepository stockRepository ;


    @Override
    public Stock save(Stock entity) {
        entity.setCreateAt(LocalDateTime.now());
        return stockRepository.save(entity);
    }

}
