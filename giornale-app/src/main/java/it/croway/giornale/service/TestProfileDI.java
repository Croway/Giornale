package it.croway.giornale.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("integrationTest")
public class TestProfileDI extends TestDI {

	@Override
	public String test() {
		return "CODICE TEST PROFILE";
	}
	
}
