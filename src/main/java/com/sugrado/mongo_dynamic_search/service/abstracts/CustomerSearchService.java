package com.sugrado.mongo_dynamic_search.service.abstracts;

import com.sugrado.mongo_dynamic_search.dto.DynamicQuery;
import com.sugrado.mongo_dynamic_search.model.Customer;

import java.util.List;

public interface CustomerSearchService {
    void add(Customer customer);

    void delete(int customerId);

    List<Customer> searchCustomers(DynamicQuery dynamicQuery);
}
