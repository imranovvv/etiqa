package com.demo.etiqa.dto;

import lombok.Data;

@Data
public class CustomerDTO {
    private String firstName;
    private String lastName;
    private String personalEmail;
    private String officeEmail;
    private Integer familyMembers;
}

