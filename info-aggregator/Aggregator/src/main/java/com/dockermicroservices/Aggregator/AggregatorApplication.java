package com.dockermicroservices.Aggregator;

import com.dockermicroservices.Aggregator.entities.AggregatedDataResponseDto;
import com.dockermicroservices.Aggregator.entities.Chart;
import com.dockermicroservices.Aggregator.entities.User;
import com.dockermicroservices.Aggregator.services.ChartService;
import com.dockermicroservices.Aggregator.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController("/aggregator")
@SpringBootApplication
public class AggregatorApplication {

	@Autowired
	ChartService chartService;

	@Autowired
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(AggregatorApplication.class, args);
	}

	@GetMapping
	public AggregatedDataResponseDto aggregateData(@RequestParam String email){
		AggregatedDataResponseDto responseDto;
		User user = userService.getUser(email);
		if(user!=null){
			Chart chart = chartService.getChartForUser(user.getId());
			responseDto = new AggregatedDataResponseDto(user, chart);
		}else{
			responseDto = new AggregatedDataResponseDto();
		}
		return responseDto;
	}

	@GetMapping("/test")
	public String health(@RequestParam String name){
		return "I'm ok " + name;
	}
}
