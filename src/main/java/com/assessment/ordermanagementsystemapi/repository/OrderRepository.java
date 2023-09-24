package com.assessment.ordermanagementsystemapi.repository;

import com.assessment.ordermanagementsystemapi.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findOrdersBySubmissionDate(Date date);
}
