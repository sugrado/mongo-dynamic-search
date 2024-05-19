package com.sugrado.mongo_dynamic_search.business.abstracts;

import com.sugrado.mongo_dynamic_search.core.services.search.models.DynamicQuery;
import com.sugrado.mongo_dynamic_search.entities.concretes.Customer;

import java.util.List;

public interface CustomerSearchService {
    void add(Customer customer);

    void delete(int customerId);

    List<Customer> searchCustomers(DynamicQuery dynamicQuery);
}
