package com.sugrado.mongo_dynamic_search.service.concretes;

import com.sugrado.mongo_dynamic_search.dto.DynamicQuery;
import com.sugrado.mongo_dynamic_search.model.Customer;
import com.sugrado.mongo_dynamic_search.repository.CustomerRepository;
import com.sugrado.mongo_dynamic_search.service.abstracts.CustomerSearchService;
import com.sugrado.mongo_dynamic_search.service.abstracts.SearchService;
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
