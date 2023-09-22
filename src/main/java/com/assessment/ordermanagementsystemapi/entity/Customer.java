package com.assessment.ordermanagementsystemapi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String registrationCode;
    private String fullName;
    private String email;
    private String telephone;

}
