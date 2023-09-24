package com.assessment.ordermanagementsystemapi.controller;

import com.assessment.ordermanagementsystemapi.service.OrderLineService;
import com.assessment.ordermanagementsystemapi.service.dto.OrderLineDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/orderLine")
public class OrderLineController {

    private final OrderLineService orderLineService;

    @PostMapping
    public ResponseEntity<OrderLineDTO> createOrderLine(@RequestBody OrderLineDTO orderLineDTO) {
        return ResponseEntity.ok(orderLineService.save(orderLineDTO));
    }

    @GetMapping
    public ResponseEntity<List<OrderLineDTO>> getAllOrderLines(){
        return ResponseEntity.ok(orderLineService.getAll());
    }
}
