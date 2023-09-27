package com.assessment.ordermanagementsystemapi.service;

import com.assessment.ordermanagementsystemapi.entity.Product;
import com.assessment.ordermanagementsystemapi.repository.ProductRepository;
import com.assessment.ordermanagementsystemapi.service.dto.ProductDTO;
import com.assessment.ordermanagementsystemapi.service.mapper.ProductMapper;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductMapper productMapper;

    @InjectMocks
    private ProductService productService;

    @Test
    void testSaveProduct() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(1L);
        productDTO.setName("Jolt Cola");
        productDTO.setSkuCode("G7119");
        productDTO.setUnitPrice(19.99);

        Product product = new Product();
        product.setId(1L);
        product.setName("Jolt Cola");
        product.setSkuCode("G7119");
        product.setUnitPrice(19.99);

        when(productMapper.toEntity(productDTO)).thenReturn(product);
        when(productRepository.save(product)).thenReturn(product);
        when(productMapper.toDto(product)).thenReturn(productDTO);

        ProductDTO savedProductDTO = productService.save(productDTO);

        Assertions.assertThat(savedProductDTO).isEqualTo(productDTO);
        verify(productRepository, times(1)).save(product);
    }

    @Test
    void testGetAllProduct() {
        List<Product> products = new ArrayList<>();

        when(productRepository.findAll()).thenReturn(products);
        when(productMapper.entitiesToDTOs(products)).thenReturn(new ArrayList<>());

        List<ProductDTO> productDTOs = productService.getAll();

        Assertions.assertThat(productDTOs).isEmpty();
    }
}