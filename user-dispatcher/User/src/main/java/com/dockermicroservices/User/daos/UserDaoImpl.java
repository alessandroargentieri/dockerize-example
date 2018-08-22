package com.dockermicroservices.User.daos;

import com.dockermicroservices.User.entities.User;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserDaoImpl implements UserDao{

    private List<User> users;

    @Override
    public User getUserByEmail(String email) {
        return users.stream().filter(user -> email.equals(user.getEmail())).limit(1).collect(Collectors.toList()).get(0);
    }


    @PostConstruct
    private void fillList(){
        users = new ArrayList<>();
        users.add(new User("cd32", "alessandroargentieri@libero.it", "Alessandro Argentieri"));
        users.add(new User("cd33", "deborarossini@libero.it", "Debora Rossini"));
        users.add(new User("cd34", "teoargentieri@libero.it", "Teo Argentieri"));
    }

}
