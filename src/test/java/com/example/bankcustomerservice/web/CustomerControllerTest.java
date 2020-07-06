package com.example.bankcustomerservice.web;

import com.example.bankcustomerservice.web.controller.CustomerController;
import com.example.bankcustomerservice.web.model.Customer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void getCustomerById () throws Exception {

        mockMvc.perform(get("/api/v1/customer/"+ UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void saveCustomer() throws Exception {
        Customer customer = Customer.builder().build();
        String customerJson = objectMapper.writeValueAsString(customer);

        mockMvc.perform(post("/api/v1/customer/").contentType(MediaType.APPLICATION_JSON).content(customerJson)).andExpect(status().isCreated());
    }
    @Test
    public void updateCustomerById() throws Exception {
        Customer customer = Customer.builder().build();
        String customerJson = objectMapper.writeValueAsString(customer);

        mockMvc.perform(put("/api/v1/customer/"+UUID.randomUUID()).contentType(MediaType.APPLICATION_JSON).content(customerJson)).andExpect(status().isNoContent());

    }
    @Test
    public void deleteCustomerById() throws Exception {
        mockMvc.perform(delete("/api/v1/customer/"+UUID.randomUUID())).andExpect(status().isNoContent());

    }
}
