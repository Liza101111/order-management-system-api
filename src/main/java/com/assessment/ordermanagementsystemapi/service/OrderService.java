package com.assessment.ordermanagementsystemapi.service;

import com.assessment.ordermanagementsystemapi.entity.Order;
import com.assessment.ordermanagementsystemapi.entity.OrderLine;
import com.assessment.ordermanagementsystemapi.exception.ResourceNotFoundException;
import com.assessment.ordermanagementsystemapi.repository.OrderRepository;
import com.assessment.ordermanagementsystemapi.service.dto.OrderDTO;
import com.assessment.ordermanagementsystemapi.service.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private static String message = "Order not found with id: ";

    public OrderDTO save(OrderDTO orderDTO) {
        Order order = orderMapper.toEntity(orderDTO);
        Order savedOrder = orderRepository.save(order);
        return orderMapper.toDto(savedOrder);
    }

    public List<OrderDTO> getAll(){
        List<Order> orders = orderRepository.findAll();
        return orderMapper.entitiesToDTOs(orders);
    }

    public List<OrderDTO> getOrdersByDate(Date date) {
        List<Order> orders = orderRepository.findOrdersBySubmissionDate(date);
        return orderMapper.entitiesToDTOs(orders);
    }

    public List<OrderDTO> getOrdersByProduct(String productName){
        List<Order> orders = orderRepository.findByProduct(productName);
        return orderMapper.entitiesToDTOs(orders);
    }

    public List<OrderDTO> getOrdersByCustomer(String customerName){
        List<Order> orders = orderRepository.findByCustomer(customerName);
        return orderMapper.entitiesToDTOs(orders);
    }

    public OrderDTO findById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(message + id));
        return orderMapper.toDto(order);
    }

    public OrderDTO updateOrder(Long id, OrderDTO orderDTO){
        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(message + id));
        orderMapper.updateOrderFromDto(orderDTO, existingOrder);
        Order updatedOrder = orderRepository.save(existingOrder);

        return orderMapper.toDto(updatedOrder);
    }

    public void deleteOrder(Long id){
        Order order = orderRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(message + id));
        orderRepository.delete(order);
    }

    public OrderDTO changeQuantityInOrderLine(Long orderId, Long orderLineId, int newQuantity){

        //Retrieve the order by orderId
        Order order = orderRepository.findById(orderId)
                .orElseThrow(()-> new ResourceNotFoundException(message + orderId));

        //Find the specific order line in the order
        OrderLine orderLine = order.getOrderLines()
                .stream()
                .filter(line -> line.getId().equals(orderLineId))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("OrderLine not found with id: " + orderLineId));

        //Update the quantity of the order line
        orderLine.setQuantity(newQuantity);

        Order updatedOrder = orderRepository.save(order);

        return orderMapper.toDto(updatedOrder);
    }

}
