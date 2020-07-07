package com.example.bankcustomerservice.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.sql.Timestamp;
import java.time.OffsetDateTime;
import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDto {
    @Null
    private UUID id;
    @NotNull
    private String name;
    @NotNull
    private String address;
    @NotNull
    private CustomerType type;
    private OffsetDateTime createdDate;

    private OffsetDateTime lastModifiedDate;
}
