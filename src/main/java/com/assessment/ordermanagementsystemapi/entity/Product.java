package com.assessment.ordermanagementsystemapi.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String skuCode;
    private double unitPrice;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL)
    private List<OrderLine> orderLines;
}
