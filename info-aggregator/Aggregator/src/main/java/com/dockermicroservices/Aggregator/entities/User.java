package com.dockermicroservices.Aggregator.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data
public class User {
    private String id;
    private String email;
    private String name;
}
