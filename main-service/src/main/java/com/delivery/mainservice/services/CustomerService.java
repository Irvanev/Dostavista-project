package com.delivery.mainservice.services;

import com.delivery.mainservice.dtos.customerDtos.CreateCustomerDto;
import com.delivery.mainservice.dtos.customerDtos.CustomerDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface CustomerService {
    CustomerDto createCustomers(CreateCustomerDto createCustomerDto);
    void deleteCustomer(UUID id);
    CustomerDto editCustomer(UUID id, CreateCustomerDto createCustomerDto);
    Page<CustomerDto> getAllCustomers(Pageable pageable);
    Optional<CustomerDto> getCustomer(UUID id);
}
