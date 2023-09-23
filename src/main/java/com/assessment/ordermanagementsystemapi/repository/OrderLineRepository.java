package com.assessment.ordermanagementsystemapi.repository;

import com.assessment.ordermanagementsystemapi.entity.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {
}
