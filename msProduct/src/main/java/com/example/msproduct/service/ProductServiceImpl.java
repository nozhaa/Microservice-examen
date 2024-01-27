package com.example.msproduct.service;
import com.example.msproduct.dto.ProductDto;
import com.example.msproduct.entity.Product;
import com.example.msproduct.dto.StockDto;
import com.example.msproduct.generic.ServiceGenericImpl;

import com.example.msproduct.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;



@Service
@RequiredArgsConstructor
public class ProductServiceImpl extends ServiceGenericImpl<Product, Long> implements ProductService {

    private final ProductRepository productRepository ;

    @Autowired
    ClientStockService clientStockService;





    @Override
    public Product save(Product entity) {
        entity.setCreateAt(LocalDateTime.now());
        return productRepository.save(entity);
    }

    @Override
    public ProductDto getProductWithStock(Long id) {

        Product product=productRepository.findById(id).orElse(null);
        StockDto stockDto =  clientStockService.getStock(product.getIdStock());

        return mapToProduct(product , stockDto);
    }






    private ProductDto mapToProduct(Product product , StockDto stock){
        ProductDto productDto = new ProductDto();
        productDto.setStock(stock);
        productDto.setName(product.getName());
        productDto.setQuantity(product.getQuantity());
        productDto.setCreateAt(product.getCreateAt());
        productDto.setUpdateAt(product.getUpdateAt());
        productDto.setId(product.getId());

        return productDto;
    }









}
