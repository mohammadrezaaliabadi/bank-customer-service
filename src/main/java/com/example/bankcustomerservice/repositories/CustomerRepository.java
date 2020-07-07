package com.example.bankcustomerservice.repositories;

import com.example.bankcustomerservice.domain.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface  CustomerRepository extends PagingAndSortingRepository<Customer, UUID> { }
