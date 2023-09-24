package com.assessment.ordermanagementsystemapi.service;

import com.assessment.ordermanagementsystemapi.entity.Product;
import com.assessment.ordermanagementsystemapi.repository.ProductRepository;
import com.assessment.ordermanagementsystemapi.service.dto.ProductDTO;
import com.assessment.ordermanagementsystemapi.service.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductDTO save(ProductDTO productDTO) {
        Product product = productMapper.toEntity(productDTO);
        Product savedProduct = productRepository.save(product);
        return productMapper.toDto(savedProduct);
    }
}
