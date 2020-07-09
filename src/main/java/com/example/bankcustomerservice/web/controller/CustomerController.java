package com.example.bankcustomerservice.web.controller;

import com.example.bankcustomerservice.repositories.CustomerRepository;
import com.example.bankcustomerservice.services.CustomerService;
import com.example.bankcustomerservice.web.mapper.CustomerMapper;
import com.example.bankcustomerservice.web.model.CustomerDto;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.data.crossstore.ChangeSetPersister;
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
    private final CustomerService customerService;
    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomer(@NotNull @PathVariable("customerId")UUID customerId) throws ChangeSetPersister.NotFoundException {
        return new ResponseEntity<>(customerService.getById(customerId,false), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity saveCustomer(@NotNull @Validated @RequestBody CustomerDto customerDto){
        return new ResponseEntity(customerService.save(customerDto),HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity updateCustomer(@NotNull @PathVariable("customerId") UUID customerId,@NotNull @Validated @RequestBody CustomerDto customerDto) throws ChangeSetPersister.NotFoundException {

        return new ResponseEntity(customerService.updateCustomer(customerId,customerDto),HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@NotNull @PathVariable("customerId") UUID customerId){
        // todo impl
    }

}
