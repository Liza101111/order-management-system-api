package com.assessment.ordermanagementsystemapi.repository;

import com.assessment.ordermanagementsystemapi.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
