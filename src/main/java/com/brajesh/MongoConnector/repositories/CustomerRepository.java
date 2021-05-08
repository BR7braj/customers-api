package com.brajesh.MongoConnector.repositories;

import com.brajesh.MongoConnector.collections.Customers;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CustomerRepository extends MongoRepository<Customers , String> {
    
}
