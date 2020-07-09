package com.example.bankcustomerservice.services;

import com.example.bankcustomerservice.web.model.CustomerDto;
import com.example.bankcustomerservice.web.model.CustomerPagedList;
import com.example.bankcustomerservice.web.model.CustomerTypeDto;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.PageRequest;

import java.util.UUID;

public interface CustomerService {
    CustomerPagedList listBeers(String customerName, CustomerTypeDto beerStyle, PageRequest pageRequest, Boolean showInventoryOnHand);

    CustomerDto getById(UUID customerId, Boolean showInventoryOnHand) throws ChangeSetPersister.NotFoundException;

    CustomerDto save(CustomerDto customerDto);

    CustomerDto updateCustomer(UUID customerId, CustomerDto customerDto) throws ChangeSetPersister.NotFoundException;

}
