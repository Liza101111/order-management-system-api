package com.assessment.ordermanagementsystemapi.service;

import com.assessment.ordermanagementsystemapi.entity.Order;
import com.assessment.ordermanagementsystemapi.repository.OrderRepository;
import com.assessment.ordermanagementsystemapi.service.dto.OrderDTO;
import com.assessment.ordermanagementsystemapi.service.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderDTO save(OrderDTO orderDTO) {
        Order order = orderMapper.toEntity(orderDTO);
        Order savedOrder = orderRepository.save(order);
        return orderMapper.toDto(savedOrder);
    }

}
