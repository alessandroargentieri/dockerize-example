package com.dockermicroservices.Aggregator.services;

import com.dockermicroservices.Aggregator.entities.User;

public interface UserService {
    User getUser(String email);
}
