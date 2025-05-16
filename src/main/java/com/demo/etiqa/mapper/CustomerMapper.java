package com.demo.etiqa.mapper;

import com.demo.etiqa.dto.CustomerDTO;
import com.demo.etiqa.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public Customer toEntity(CustomerDTO dto) {

        return Customer.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .personalEmail(dto.getPersonalEmail())
                .officeEmail(dto.getOfficeEmail())
                .familyMembers(dto.getFamilyMembers())
                .build();
    }

    public CustomerDTO toDto(Customer entity) {
        CustomerDTO dto = new CustomerDTO();
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setPersonalEmail(entity.getPersonalEmail());
        dto.setOfficeEmail(entity.getOfficeEmail());
        dto.setFamilyMembers(entity.getFamilyMembers());
        return dto;
    }
}
