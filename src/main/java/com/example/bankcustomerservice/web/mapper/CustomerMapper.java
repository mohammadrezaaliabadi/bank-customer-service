package com.example.bankcustomerservice.web.mapper;

import com.example.bankcustomerservice.domain.Customer;
import com.example.bankcustomerservice.web.model.CustomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(uses = DateMapper.class,componentModel = "spring")
public interface CustomerMapper {
    @Mapping(target = "id",ignore = true)
    Customer customerDtoToCustomer(CustomerDto customerDto);
    CustomerDto customerToCustomerDto(Customer customer);
}
