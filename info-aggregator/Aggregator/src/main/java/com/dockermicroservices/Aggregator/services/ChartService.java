package com.dockermicroservices.Aggregator.services;

import com.dockermicroservices.Aggregator.entities.Chart;

public interface ChartService {
    Chart getChartForUser(String userId);
}
