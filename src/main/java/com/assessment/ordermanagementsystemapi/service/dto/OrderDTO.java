package com.assessment.ordermanagementsystemapi.service.dto;

import com.assessment.ordermanagementsystemapi.entity.OrderLine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {

    private Long id;
    private Date submissionDate;
    private CustomerDTO customer;
    private List<OrderLine> orderLines;
}
