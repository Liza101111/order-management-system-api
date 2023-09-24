package com.assessment.ordermanagementsystemapi.service;

import com.assessment.ordermanagementsystemapi.entity.Customer;
import com.assessment.ordermanagementsystemapi.repository.CustomerRepository;
import com.assessment.ordermanagementsystemapi.service.dto.CustomerDTO;
import com.assessment.ordermanagementsystemapi.service.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerDTO save(CustomerDTO customerDTO){
        Customer customer = customerMapper.toEntity(customerDTO);
        Customer savedCustomer = customerRepository.save(customer);
        return customerMapper.toDto(savedCustomer);
    }
}
