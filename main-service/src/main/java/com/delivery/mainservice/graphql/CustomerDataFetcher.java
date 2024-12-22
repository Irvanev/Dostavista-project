package com.delivery.mainservice.graphql;

import com.delivery.mainservice.dtos.customerDtos.CreateCustomerDto;
import com.delivery.mainservice.dtos.customerDtos.CustomerDto;
import com.delivery.mainservice.models.entities.Customers;
import com.delivery.mainservice.repositories.CustomerRepository;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import org.modelmapper.ModelMapper;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@DgsComponent
public class CustomerDataFetcher {

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    public CustomerDataFetcher(CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    @DgsQuery
    public Optional<CustomerDto> findCustomerById(@InputArgument UUID id) {
        return customerRepository.findById(id).map(customer -> modelMapper.map(customer, CustomerDto.class));
    }

    @DgsQuery
    public List<CustomerDto> findAllCustomers() {
        return customerRepository.findAll().stream().map(customer -> modelMapper.map(customer, CustomerDto.class))
                .collect(Collectors.toList());
    }

    @DgsMutation
    public CustomerDto createCustomer(CreateCustomerDto createCustomerDto) {
        Customers customers = modelMapper.map(createCustomerDto, Customers.class);

        customers.setCreatedAt(new Date());

        return modelMapper.map(customerRepository.saveAndFlush(customers), CustomerDto.class);
    }

    @DgsMutation
    public boolean deleteCustomer(UUID id) {
        customerRepository.deleteById(id);
        return true;
    }
}
