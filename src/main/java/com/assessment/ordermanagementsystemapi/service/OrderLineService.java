package com.assessment.ordermanagementsystemapi.service;

import com.assessment.ordermanagementsystemapi.entity.OrderLine;
import com.assessment.ordermanagementsystemapi.repository.OrderLineRepository;
import com.assessment.ordermanagementsystemapi.service.dto.OrderLineDTO;
import com.assessment.ordermanagementsystemapi.service.mapper.OrderLineMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderLineService {

    private final OrderLineRepository orderLineRepository;
    private final OrderLineMapper orderLineMapper;

    public OrderLineDTO save(OrderLineDTO orderLineDTO) {
        OrderLine orderLine = orderLineMapper.toEntity(orderLineDTO);
        OrderLine savedOrderLine =orderLineRepository.save(orderLine);
        return orderLineMapper.toDto(savedOrderLine);
    }

    public List<OrderLineDTO> getAll() {
        List<OrderLine> orderLines = orderLineRepository.findAll();
        return orderLineMapper.entitiesToDTOs(orderLines);
    }
}
