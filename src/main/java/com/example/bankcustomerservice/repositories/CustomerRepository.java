package com.example.bankcustomerservice.repositories;

import com.example.bankcustomerservice.web.model.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

public interface   CustomerRepository extends PagingAndSortingRepository<Customer, UUID> { }
