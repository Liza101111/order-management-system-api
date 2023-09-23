package com.assessment.ordermanagementsystemapi.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    private Long id;
    private String registrationCode;
    private String fullName;
    private String email;
    private String telephone;

}
