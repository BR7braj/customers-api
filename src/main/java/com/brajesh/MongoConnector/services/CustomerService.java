package com.brajesh.MongoConnector.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.brajesh.MongoConnector.collections.Customers;
import com.brajesh.MongoConnector.repositories.CustomerRepository;
import com.mongodb.MongoException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.extern.java.Log;

@Service
@Log
public class CustomerService {

    private final CustomerRepository repo;

    @Autowired
    public CustomerService(CustomerRepository repo)
    {
        this.repo = repo;
    }

    public List<Customers> getCutomers() {
        return repo.findAll();
    }
    
    public void addCustomer(Customers customer) {
       try{
        repo.insert(customer);
       }catch(Exception e)
       {
           log.info("Inserting cutomer" + e.getMessage());
       }
    }

    public ResponseEntity<Customers> updateCustomer(String id, Customers customerDetails) throws Exception {
      
      Customers customer = repo.findById(id).orElseThrow(() -> new Exception("User not found on ::" + id));
       
       customer.setAccounts(customerDetails.getAccounts());
       customer.setAddress(customerDetails.getAddress());
       customer.setAddress(customerDetails.getAddress());
       customer.setBirthdate(customerDetails.getBirthdate());
       customer.setEmail(customerDetails.getEmail());
       customer.setUsername(customerDetails.getUsername());
       
       final Customers updatedCustomer =  repo.save(customer);
       return ResponseEntity.ok(updatedCustomer);

    }

    public ResponseEntity<Map<String, Boolean>> deleteCustomer(String id) {
        
        Customers customer = repo.findById(id).orElseThrow(() -> new MongoException("Resource not found on id::" + id));
        repo.delete(customer);
        Map<String, Boolean> response   = new HashMap<>();
        response.put("deleted" , Boolean.TRUE);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    
}
