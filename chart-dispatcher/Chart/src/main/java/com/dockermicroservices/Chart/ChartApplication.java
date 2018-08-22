package com.dockermicroservices.Chart;

import com.dockermicroservices.Chart.daos.ChartDao;
import com.dockermicroservices.Chart.entities.Chart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController("/chart")
@SpringBootApplication
public class ChartApplication {

	@Autowired
	ChartDao chartDao;

	public static void main(String[] args) {
		SpringApplication.run(ChartApplication.class, args);
	}

	@GetMapping
	public Chart getChartForUser(@RequestParam String userId){
		return chartDao.getChartGivenUserId(userId);
	}
}
