package com.assessment.ordermanagementsystemapi.service.mapper;

import com.assessment.ordermanagementsystemapi.entity.OrderLine;
import com.assessment.ordermanagementsystemapi.service.dto.OrderLineDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderLineMapper {

    OrderLineDTO toDto(OrderLine orderLine);
    OrderLine toEntity(OrderLineDTO orderLineDTO);
    List<OrderLineDTO> entitiesToDTOs(List<OrderLine> orderLines);
}
