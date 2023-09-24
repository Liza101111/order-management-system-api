package com.assessment.ordermanagementsystemapi.service.mapper;

import com.assessment.ordermanagementsystemapi.entity.Order;
import com.assessment.ordermanagementsystemapi.service.dto.OrderDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDTO toDto(Order order);
    Order toEntity(OrderDTO orderDTO);

    List<OrderDTO> entitiesToDtos(List<Order> orders);

}
