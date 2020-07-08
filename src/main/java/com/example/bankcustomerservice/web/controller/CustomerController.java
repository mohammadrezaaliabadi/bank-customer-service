package com.example.bankcustomerservice.web.controller;

import com.example.bankcustomerservice.repositories.CustomerRepository;
import com.example.bankcustomerservice.web.mapper.CustomerMapper;
import com.example.bankcustomerservice.web.model.CustomerDto;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Controller
@Validated
@RequestMapping("/api/v1/customer")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;
    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomer(@NotNull @PathVariable("customerId")UUID customerId){
        return new ResponseEntity<>(customerMapper.customerToCustomerDto(customerRepository.findById(customerId).get()), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity saveCustomer(@NotNull @Validated @RequestBody CustomerDto customerDto){
        customerRepository.save(customerMapper.customerDtoToCustomer(customerDto));
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity updateCustomer(@NotNull @PathVariable("customerId") UUID customerId,@NotNull @Validated @RequestBody CustomerDto customerDto){
        customerRepository.findById(customerId).ifPresent(customer -> {
            val customerSave = customerMapper.customerDtoToCustomer(customerDto);
            customerSave.setId(customer.getId());
            customerRepository.save(customerSave);
        });
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@NotNull @PathVariable("customerId") UUID customerId){
        // todo impl
    }

}
