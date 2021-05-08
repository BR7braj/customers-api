package com.brajesh.MongoConnector.Controller;

import java.util.List;
import java.util.Map;

import com.brajesh.MongoConnector.collections.Customers;
import com.brajesh.MongoConnector.services.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.java.Log;


@Controller
@Log
@RequestMapping("/api")
public class CustomerController {

    private final CustomerService service;

    @Autowired
    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customers>> getCustomers() {
        log.info("Inside the controlleer");
        return ResponseEntity.ok().body(this.service.getCutomers());
    }

    @PostMapping("/add/customer")
    public ResponseEntity<Void> addCustomer(@RequestBody Customers customers)
    {   
        

        try{
        this.service.addCustomer(customers);
        return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    } 

    @PutMapping("/update/customer/{id}")
    public ResponseEntity<Customers> updateCustomer( @PathVariable String id , @RequestBody Customers customer) throws Exception
        {
            
            return   this.service.updateCustomer(id , customer); 
            
        }

    @DeleteMapping("/delete/customer/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable (value = "id") String id)
        {
            return this.service.deleteCustomer(id);
        }
    
    
}
