package com.assessment.ordermanagementsystemapi.service.mapper;

import com.assessment.ordermanagementsystemapi.entity.Order;
import com.assessment.ordermanagementsystemapi.service.dto.OrderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDTO toDto(Order order);
    Order toEntity(OrderDTO orderDTO);
    List<OrderDTO> entitiesToDTOs(List<Order> orders);

    @Mapping(target = "id", ignore = true)
    void updateOrderFromDto(OrderDTO orderDTO, @MappingTarget Order order);
}


