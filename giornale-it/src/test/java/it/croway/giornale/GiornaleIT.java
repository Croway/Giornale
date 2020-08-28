package it.croway.giornale;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class GiornaleIT {
	
	RestTemplate restTemplate = new RestTemplate();

	@Test
	void baseTest() {
		ResponseEntity<String> re = restTemplate.getForEntity("http://localhost:8081/notizie", String.class);
		
		Assertions.assertEquals(200, re.getStatusCodeValue());
	}
	
}
