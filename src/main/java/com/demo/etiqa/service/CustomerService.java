package com.demo.etiqa.service;


import com.demo.etiqa.dto.CustomerDTO;
import com.demo.etiqa.entity.Customer;
import com.demo.etiqa.exception.CustomerNotFoundException;
import com.demo.etiqa.mapper.CustomerMapper;
import com.demo.etiqa.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public Customer createCustomer(CustomerDTO customerDTO) {
        Customer customer = customerMapper.toEntity(customerDTO);
        return customerRepository.save(customer);
    }

    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(customerMapper::toDto)
                .collect(Collectors.toList());
    }

    public CustomerDTO getCustomerById(Long id) {
        return customerRepository.findById(id)
                .map(customerMapper::toDto)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with id " + id));
    }

    public Customer updateCustomer(Long id, CustomerDTO updated) {
        return customerRepository.findById(id).map(existing -> {
            existing.setFirstName(updated.getFirstName());
            existing.setLastName(updated.getLastName());
            existing.setPersonalEmail(updated.getPersonalEmail());
            existing.setOfficeEmail(updated.getOfficeEmail());
            existing.setFamilyMembers(updated.getFamilyMembers());
            return customerRepository.save(existing);
        }).orElseThrow(() -> new CustomerNotFoundException("Customer not found with id " + id));
    }


        public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }


}

