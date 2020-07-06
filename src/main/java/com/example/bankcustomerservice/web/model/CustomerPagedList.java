package com.example.bankcustomerservice.web.model;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class CustomerPagedList extends PageImpl<Customer> implements Serializable {
    public CustomerPagedList(List<Customer> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public CustomerPagedList(List<Customer> content) {
        super(content);
    }
}
