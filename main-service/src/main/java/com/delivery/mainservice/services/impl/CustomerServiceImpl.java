package com.delivery.mainservice.services.impl;

import com.delivery.mainservice.dtos.customerDtos.CreateCustomerDto;
import com.delivery.mainservice.dtos.customerDtos.CustomerDto;
import com.delivery.mainservice.models.entities.Customers;
import com.delivery.mainservice.repositories.CustomerRepository;
import com.delivery.mainservice.services.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CustomerDto createCustomers(CreateCustomerDto createCustomerDto) {
        Customers customers = modelMapper.map(createCustomerDto, Customers.class);

        customers.setCreatedAt(new Date());

        return modelMapper.map(customerRepository.saveAndFlush(customers), CustomerDto.class);
    }

    @Override
    public void deleteCustomer(UUID id) {
        customerRepository.deleteById(id);
    }

    @Override
    public CustomerDto editCustomer(UUID id, CreateCustomerDto createCustomerDto) {
        Customers customers = customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));

        modelMapper.map(createCustomerDto, customers);

        return modelMapper.map(customerRepository.saveAndFlush(customers), CustomerDto.class);
    }

    @Override
    public Page<CustomerDto> getAllCustomers(Pageable pageable) {
        Page<Customers> customersPage = customerRepository.findAll(pageable);
        return customersPage.map(customer -> modelMapper.map(customer, CustomerDto.class));
    }

    @Override
    public Optional<CustomerDto> getCustomer(UUID id) {
        return customerRepository.findById(id).map(customer -> modelMapper.map(customer, CustomerDto.class));
    }
}
