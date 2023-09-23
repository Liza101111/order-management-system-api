package com.assessment.ordermanagementsystemapi.repository;

import com.assessment.ordermanagementsystemapi.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
