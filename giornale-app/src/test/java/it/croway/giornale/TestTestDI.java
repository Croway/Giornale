package it.croway.giornale;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import it.croway.giornale.service.TestDI;

@SpringBootTest
class TestTestDI {

	@Autowired
	TestDI testDi;

	@Test
	void testDi() {
		Assertions.assertEquals("CODICE MOCK", testDi.test());
	}

}

@Service
@Primary
class MockTestDI extends TestDI {

	public String test() {
		return "CODICE MOCK";
	}

}