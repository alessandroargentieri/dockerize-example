package com.dockermicroservices.User;

import com.dockermicroservices.User.daos.UserDao;
import com.dockermicroservices.User.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController("/user")
@SpringBootApplication
public class UserApplication {

	@Autowired
	UserDao userDao;

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

	@GetMapping
	public User retrieveUser(@RequestParam String email){
		return userDao.getUserByEmail(email);
	}
}
