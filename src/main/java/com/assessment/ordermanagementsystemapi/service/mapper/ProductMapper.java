package com.assessment.ordermanagementsystemapi.service.mapper;

import com.assessment.ordermanagementsystemapi.entity.Product;
import com.assessment.ordermanagementsystemapi.service.dto.ProductDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO toDto(Product product);
    Product toEntity(ProductDTO productDTO);
    List<ProductDTO> entitiesToDTOs(List<Product> products);

}
