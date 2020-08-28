package it.croway.giornale.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ValidatoreCodiceFiscale implements IValidatoreCodiceFiscale {

	@Autowired
	RestTemplate restTemplate;

	public boolean valida(String codiceFiscale) {
		return restTemplate
				.postForEntity("http://agz.gov.it/validaCF", "{ cf: \"" + codiceFiscale + "\" }", Boolean.class)
				.getBody();
	}

}
