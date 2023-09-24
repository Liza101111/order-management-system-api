package com.assessment.ordermanagementsystemapi.service.mapper;

import com.assessment.ordermanagementsystemapi.entity.OrderLine;
import com.assessment.ordermanagementsystemapi.service.dto.OrderLineDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderLineMapper {

    OrderLineDTO toDto(OrderLine orderLine);
    OrderLine toEntity(OrderLineDTO orderLineDTO);
}
