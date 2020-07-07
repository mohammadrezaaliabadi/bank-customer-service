package com.example.bankcustomerservice.web.controller;

import com.example.bankcustomerservice.web.model.CustomerDto;
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
public class CustomerController {
    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomer(@NotNull @PathVariable("customerId")UUID customerId){
        // todo impl
        return new ResponseEntity<>(CustomerDto.builder().build(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity saveCustomer(@NotNull @Validated @RequestBody CustomerDto customerDto){
        // todo impl
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity updateCustomer(@NotNull @PathVariable("customerId") UUID customerId,@NotNull @Validated @RequestBody CustomerDto customerDto){
        // todo impl
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@NotNull @PathVariable("customerId") UUID customerId){
        // todo impl
    }

}
