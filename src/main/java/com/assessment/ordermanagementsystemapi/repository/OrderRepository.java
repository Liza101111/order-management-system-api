package com.assessment.ordermanagementsystemapi.repository;

import com.assessment.ordermanagementsystemapi.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findOrdersBySubmissionDate(Date date);

    @Query("SELECT o FROM Order o JOIN o.orderLines ol JOIN ol.product p WHERE p.name = :productName")
    List<Order> findByProduct(@Param("productName") String productName);

    @Query("SELECT o FROM Order o WHERE o.customer.fullName = :customerName")
    List<Order> findByCustomer(@Param("customerName") String customerName);
}
