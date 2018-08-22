package com.dockermicroservices.Aggregator.services;

import com.dockermicroservices.Aggregator.entities.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserServiceImpl implements UserService {

    @Value("${aggregator.user.service.address}")
    String address;

    RestTemplate restTemplate = new RestTemplate();

    @Override
    public User getUser(String email) {
        return restTemplate.getForObject(address+"?email="+email, User.class);
    }
}
