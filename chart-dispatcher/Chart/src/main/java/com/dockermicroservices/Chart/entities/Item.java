package com.dockermicroservices.Chart.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data
public class Item {
    private String code;
    private String description;
    private Double price;
    private Integer quantity;
}