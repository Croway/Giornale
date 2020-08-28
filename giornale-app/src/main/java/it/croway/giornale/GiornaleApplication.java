package it.croway.giornale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class GiornaleApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(GiornaleApplication.class, args);
	}
	
}

@Configuration
class ApplicationConfiguration {
	
	@Bean
	public RestTemplate rt() {
		return new RestTemplate();
	}
	
}