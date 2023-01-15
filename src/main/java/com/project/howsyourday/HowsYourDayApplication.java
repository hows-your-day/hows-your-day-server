package com.project.howsyourday;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class HowsYourDayApplication {

	public static void main(String[] args) {
		SpringApplication.run(HowsYourDayApplication.class, args);
	}

}
