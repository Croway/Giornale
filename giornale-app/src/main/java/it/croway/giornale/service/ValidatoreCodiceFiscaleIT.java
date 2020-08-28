package it.croway.giornale.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({ "integrationTest", "local" })
public class ValidatoreCodiceFiscaleIT implements IValidatoreCodiceFiscale {

	public boolean valida(String codiceFiscale) {
		return codiceFiscale.length() == 16;
	}
	
}
