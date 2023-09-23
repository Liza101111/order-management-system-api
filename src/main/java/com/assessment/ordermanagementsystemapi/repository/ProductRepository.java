package com.assessment.ordermanagementsystemapi.repository;

import com.assessment.ordermanagementsystemapi.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
