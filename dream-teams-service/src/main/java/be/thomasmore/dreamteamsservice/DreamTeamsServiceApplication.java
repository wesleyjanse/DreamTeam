package be.thomasmore.dreamteamsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DreamTeamsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DreamTeamsServiceApplication.class, args);
	}

}
