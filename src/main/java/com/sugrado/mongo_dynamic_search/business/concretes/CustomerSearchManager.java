package com.sugrado.mongo_dynamic_search.business.concretes;

import com.sugrado.mongo_dynamic_search.business.abstracts.CustomerSearchService;
import com.sugrado.mongo_dynamic_search.core.services.search.SearchService;
import com.sugrado.mongo_dynamic_search.core.services.search.models.DynamicQuery;
import com.sugrado.mongo_dynamic_search.data_access.abstracts.CustomerRepository;
import com.sugrado.mongo_dynamic_search.entities.concretes.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerSearchManager implements CustomerSearchService {
    private final CustomerRepository customerRepository;
    private final SearchService searchService;

    @Override
    public void add(Customer customer) {
        this.customerRepository.save(customer);
    }

    @Override
    public void delete(int customerId) {
        this.customerRepository.deleteById(customerId);
    }

    public List<Customer> searchCustomers(DynamicQuery dynamicQuery) {
        return searchService.dynamicSearch(dynamicQuery, Customer.class);
    }
}
