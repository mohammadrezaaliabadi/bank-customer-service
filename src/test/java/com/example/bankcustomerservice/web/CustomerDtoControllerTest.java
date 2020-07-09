package com.example.bankcustomerservice.web;

import com.example.bankcustomerservice.domain.Customer;
import com.example.bankcustomerservice.repositories.CustomerRepository;
import com.example.bankcustomerservice.services.CustomerService;
import com.example.bankcustomerservice.web.controller.CustomerController;
import com.example.bankcustomerservice.web.model.CustomerDto;
import com.example.bankcustomerservice.web.model.CustomerTypeDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.constraints.ConstraintDescriptions;
import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.StringUtils;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.restdocs.snippet.Attributes.key;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(RestDocumentationExtension.class)
@AutoConfigureRestDocs(uriScheme = "https",uriHost = "dev.book",uriPort = 8081)
@WebMvcTest(CustomerController.class)
@ComponentScan(basePackages = "com.example.bankcustomerservice.web.mapper")
public class CustomerDtoControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    CustomerService customerService;

    @Test
    public void getCustomerById() throws Exception {
        given(customerService.getById(any(),any())).willReturn(getValidCustomer());
        mockMvc.perform(get("/api/v1/customer/{customerId}", UUID.randomUUID().toString())
                .param("name", "ali")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(document("v1/customer-get", pathParameters(
                        parameterWithName("customerId").description("UUID of desired customer to get.")
                ), requestParameters(
                        parameterWithName("name").description("Is Customer name query param.")
                ), responseFields(
                        fieldWithPath("customerId").description("id of customer"),
                        fieldWithPath("name").description("name of customer"),
                        fieldWithPath("address").description("address"),
                        fieldWithPath("type").description("type of customer"),
                        fieldWithPath("createdDate").description("Date Created"),
                        fieldWithPath("lastModifiedDate").description("Date Updated")

                )));

    }

    @Test
    public void saveCustomer() throws Exception {
        CustomerDto customerDto = getValidCustomer();
        String customerJson = objectMapper.writeValueAsString(customerDto);

        ConstrainedFields fields = new ConstrainedFields(Customer.class);


        mockMvc.perform(post("/api/v1/customer/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(customerJson))
                .andExpect(status().isCreated())
                .andDo(document("v1/customer-new",
                        requestFields(
                                fields.withPath("customerId").ignored(),
                                fields.withPath("name").description("name of customer"),
                                fields.withPath("address").description("address"),
                                fields.withPath("type").description("type of customer"),
                                fields.withPath("createdDate").description("Date Created"),
                                fields.withPath("lastModifiedDate").description("Date Updated")
                        )
                ));
    }

    @Test
    public void updateCustomerById() throws Exception {
        CustomerDto customerDto = getValidCustomer();
        String customerJson = objectMapper.writeValueAsString(customerDto);

        mockMvc.perform(put("/api/v1/customer/" + UUID.randomUUID()).contentType(MediaType.APPLICATION_JSON).content(customerJson)).andExpect(status().isNoContent());

    }
//    @Test
//    public void deleteCustomerById() throws Exception {
//        mockMvc.perform(delete("/api/v1/customer/"+UUID.randomUUID())).andExpect(status().isNoContent());
//
//    }

    CustomerDto getValidCustomer() {
        return CustomerDto.builder()
                .address("Ali")
                .name("Ahmad")
                .type(CustomerTypeDto.SPECIAL)
                .build();
    }

    private static class ConstrainedFields {

        private final ConstraintDescriptions constraintDescriptions;

        ConstrainedFields(Class<?> input) {
            this.constraintDescriptions = new ConstraintDescriptions(input);
        }

        private FieldDescriptor withPath(String path) {
            return fieldWithPath(path).attributes(key("constraints").value(StringUtils
                    .collectionToDelimitedString(this.constraintDescriptions
                            .descriptionsForProperty(path), ". ")));
        }
    }
}
