package com.example.bankcustomerservice.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.time.OffsetDateTime;
import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDto {
    @Null
    private UUID customerId;
    @NotNull
    private String name;
    @NotNull
    private String address;
    private CustomerTypeDto type;
    private OffsetDateTime createdDate;

    private OffsetDateTime lastModifiedDate;
}
