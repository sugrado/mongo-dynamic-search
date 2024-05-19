package com.sugrado.mongo_dynamic_search.controller;

import com.sugrado.mongo_dynamic_search.dto.DynamicQuery;
import com.sugrado.mongo_dynamic_search.model.Customer;
import com.sugrado.mongo_dynamic_search.service.abstracts.CustomerSearchService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/customers")
public class CustomersController {
    private final CustomerSearchService customerSearchService;

    @PostMapping("/dynamic-search")
    public List<Customer> searchCustomers(@RequestBody DynamicQuery dynamicQuery) {
        return customerSearchService.searchCustomers(dynamicQuery);
    }

    @PostMapping
    public void add(@RequestBody Customer customer) {
        customerSearchService.add(customer);
    }
}
