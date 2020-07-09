package com.example.bankcustomerservice.services;

import com.example.bankcustomerservice.domain.Customer;
import com.example.bankcustomerservice.repositories.CustomerRepository;
import com.example.bankcustomerservice.web.mapper.CustomerMapper;
import com.example.bankcustomerservice.web.model.CustomerDto;
import com.example.bankcustomerservice.web.model.CustomerPagedList;
import com.example.bankcustomerservice.web.model.CustomerTypeDto;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Override
    public CustomerPagedList listBeers(String customerName, CustomerTypeDto beerStyle, PageRequest pageRequest, Boolean showInventoryOnHand) {
        //todo impl
        return null;
    }

    @Override
    public CustomerDto getById(UUID customerId, Boolean showInventoryOnHand) throws ChangeSetPersister.NotFoundException {
        return customerMapper.customerToCustomerDto(customerRepository.findById(customerId).orElseThrow(ChangeSetPersister.NotFoundException::new));
    }

    @Override
    public CustomerDto save(CustomerDto customerDto) {
        return customerMapper.customerToCustomerDto(customerRepository.save(customerMapper.customerDtoToCustomer(customerDto)));
    }

    @Override
    public CustomerDto updateCustomer(UUID customerId, CustomerDto customerDto) throws ChangeSetPersister.NotFoundException {
        Customer customer = customerRepository.findById(customerId).orElseThrow(ChangeSetPersister.NotFoundException::new);
        customer.setAddress(customerDto.getAddress());
        customer.setName(customerDto.getAddress());


        return customerMapper.customerToCustomerDto(customerRepository.save(customer));
    }
}
