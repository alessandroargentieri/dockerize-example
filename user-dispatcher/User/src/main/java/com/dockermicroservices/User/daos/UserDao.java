package com.dockermicroservices.User.daos;

import com.dockermicroservices.User.entities.User;

public interface UserDao {
    User getUserByEmail(String email);
}
