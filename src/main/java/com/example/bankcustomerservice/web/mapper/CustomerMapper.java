package com.example.bankcustomerservice.web.mapper;

import com.example.bankcustomerservice.domain.Customer;
import com.example.bankcustomerservice.web.model.CustomerDto;
import org.mapstruct.Mapper;

@Mapper(uses = DateMapper.class)
public interface CustomerMapper {
    Customer customerDtoToCustomer(CustomerDto customerDto);
    CustomerDto customerToCustomerDto(Customer customer);
}
