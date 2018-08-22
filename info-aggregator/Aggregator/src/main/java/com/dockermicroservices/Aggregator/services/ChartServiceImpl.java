package com.dockermicroservices.Aggregator.services;

import com.dockermicroservices.Aggregator.entities.Chart;
import com.dockermicroservices.Aggregator.entities.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChartServiceImpl implements ChartService {

    @Value("${aggregator.chart.service.address}")
    String address;

    RestTemplate restTemplate = new RestTemplate();

    @Override
    public Chart getChartForUser(String userId) {
        return restTemplate.getForObject(address+"?userId="+userId, Chart.class);
    }
}
