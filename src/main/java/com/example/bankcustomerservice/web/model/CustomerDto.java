package com.example.bankcustomerservice.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDto implements Serializable {
    @Null
    private UUID customerId;
    @NotNull
    private String name;
    @NotNull
    private String address;
    private CustomerTypeDto type;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ssZ", shape= JsonFormat.Shape.STRING)
    private OffsetDateTime createdDate;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ssZ", shape=JsonFormat.Shape.STRING)
    private OffsetDateTime lastModifiedDate;
}
