package com.example.bankcustomerservice.web.controller;

import com.example.bankcustomerservice.web.model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/api/v1/customer")
public class CustomerController {
    @GetMapping("/{customerId}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("customerId")UUID customerId){
        // todo impl
        return new ResponseEntity<>(Customer.builder().build(), HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity saveCustomer(@RequestBody Customer customer){
        // todo impl
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity updateCustomer(@PathVariable("customerId") UUID customerId,@RequestBody Customer customer){
        // todo impl
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@PathVariable("customerId") UUID customerId){
        // todo impl
    }

}
