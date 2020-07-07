package com.example.bankcustomerservice.bootstrap;

import com.example.bankcustomerservice.domain.Customer;
import com.example.bankcustomerservice.domain.CustomerType;
import com.example.bankcustomerservice.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CustomerLoader implements CommandLineRunner {
    @Autowired
    private final CustomerRepository customerRepository;

    public CustomerLoader(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadCustomerObjects();

    }

    private void loadCustomerObjects(){
        if (customerRepository.count() == 0){
            Customer customer = Customer.builder().name("Mohammad Reza")
                    .address("Minab")
                    .type(CustomerType.SPECIAL)
                    .build();
            Customer customer2 = Customer.builder().name("Ali Reza")
                    .address("Bandar")
                    .type(CustomerType.USUAl)
                    .build();

            customerRepository.save(customer);
            customerRepository.save(customer2);
        }

        System.out.println("Customer count:"+customerRepository.count());

    }
}
