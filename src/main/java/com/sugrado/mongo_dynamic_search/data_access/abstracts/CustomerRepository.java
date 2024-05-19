package com.sugrado.mongo_dynamic_search.data_access.abstracts;

import com.sugrado.mongo_dynamic_search.entities.concretes.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<Customer, Integer> {
}
