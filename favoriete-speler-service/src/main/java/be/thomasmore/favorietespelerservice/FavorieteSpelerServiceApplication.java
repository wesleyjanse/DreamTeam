package be.thomasmore.favorietespelerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class FavorieteSpelerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FavorieteSpelerServiceApplication.class, args);
	}

}
