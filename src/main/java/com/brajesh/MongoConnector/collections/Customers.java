package com.brajesh.MongoConnector.collections;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "customers")
public class Customers {
    @Id
    String _id;
    String username;
    String address;
    String birthdate;
    String email;
    boolean active;
    String [] accounts;
    

    
}
