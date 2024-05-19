package com.sugrado.mongo_dynamic_search.api.controllers;

import com.sugrado.mongo_dynamic_search.business.abstracts.CustomerSearchService;
import com.sugrado.mongo_dynamic_search.core.services.search.models.DynamicQuery;
import com.sugrado.mongo_dynamic_search.entities.concretes.Customer;
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
