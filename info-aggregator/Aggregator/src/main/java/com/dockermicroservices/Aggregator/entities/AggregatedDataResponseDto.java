package com.dockermicroservices.Aggregator.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data
public class AggregatedDataResponseDto {
    private User user;
    private Chart chart;
}
