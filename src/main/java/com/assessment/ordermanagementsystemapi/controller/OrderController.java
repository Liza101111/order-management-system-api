package com.assessment.ordermanagementsystemapi.controller;

import com.assessment.ordermanagementsystemapi.entity.Order;
import com.assessment.ordermanagementsystemapi.service.OrderService;
import com.assessment.ordermanagementsystemapi.service.dto.OrderDTO;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@RequestBody OrderDTO orderDTO) {
        return ResponseEntity.ok(orderService.save(orderDTO));
    }

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAll());
    }

    @GetMapping("/searchByDate")
    public ResponseEntity<List<OrderDTO>> getOrdersByDate(
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {
        List<OrderDTO> orders = orderService.getOrdersByDate(date);

        if (orders.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(orders);
        }
    }

    @GetMapping("/searchByProduct")
    //http://localhost:8080/order/searchByProduct?productName=Product1
    public ResponseEntity<List<OrderDTO>> getOrdersByProduct(
            @RequestParam("productName") String productName) {
        List<OrderDTO> orders = orderService.getOrdersByProduct(productName);

        if (orders.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(orders);
        }
    }

    @GetMapping("/searchByCustomer")
    public ResponseEntity<List<OrderDTO>> getOrdersByCustomer(
            @RequestParam("customerName") String customerName) {
        List<OrderDTO> orders = orderService.getOrdersByCustomer(customerName);

        if (orders.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(orders);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable Long id){
        OrderDTO orderDTO = orderService.findById(id);
        return ResponseEntity.ok(orderDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDTO> updateOrder(
            @PathVariable Long id, @RequestBody OrderDTO orderDTO) {
        OrderDTO updatedOrder = orderService.updateOrder(id, orderDTO);

        if(updatedOrder != null) {
            return ResponseEntity.ok(updatedOrder);
        } else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }

}
