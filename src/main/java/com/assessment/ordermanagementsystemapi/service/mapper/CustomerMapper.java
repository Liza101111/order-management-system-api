package com.assessment.ordermanagementsystemapi.service.mapper;

import com.assessment.ordermanagementsystemapi.entity.Customer;
import com.assessment.ordermanagementsystemapi.service.dto.CustomerDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CustomerMapper {
    CustomerDTO toDto(Customer customer);
    Customer toEntity(CustomerDTO customerDTO);

    List<CustomerDTO> entitiesToDtos(List<Customer> customers);
}
