package com.sugrado.mongo_dynamic_search.repository;

import com.sugrado.mongo_dynamic_search.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, Integer> {
}
