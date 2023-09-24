package com.assessment.ordermanagementsystemapi.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderLineDTO {
    private Long id;
    private ProductDTO product;
    private int quantity;
}
