package it.croway.giornale;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import it.croway.giornale.repository.entity.Notizia;
import it.croway.giornale.service.GiornaleService;
import it.croway.giornale.service.TestoSerializerDeserializerService;
import it.croway.giornale.service.TitoloFormatterService;

class GiornaleServiceTest {
	
	static TitoloFormatterService titoloFormatterService;
	static TestoSerializerDeserializerService testoSerializerDeserializerService;
	GiornaleService giornaleService;
	
	@BeforeAll
	static void init() {
		titoloFormatterService = new TitoloFormatterService();
		testoSerializerDeserializerService = new TestoSerializerDeserializerService();
//		giornaleService.
	}

	@Test
	void titoloSemplice() {
		String titolo = "semplice";
		Notizia notizia = new Notizia();
		notizia.setTitolo(titolo);
		titoloFormatterService.format(notizia);
		
		Assertions.assertEquals(titolo, notizia.getTitolo());
	}
	
	@Test
	void titoloConSpaziECaratteriSpeciali() {
		String titolo = "titolo con spazi e caratteri /& speciali";
		String expected = "titolo_con_spazi_e_caratteri__speciali";
		Notizia notizia = new Notizia();
		notizia.setTitolo(titolo);
		titoloFormatterService.format(notizia);
		
		Assertions.assertEquals(expected, notizia.getTitolo());
	}
	
	@Test
	void serializzaTesto() {
		String testo = "testo 1234 pippo pluto";
		String expected = "dGVzdG8gMTIzNCBwaXBwbyBwbHV0bw==";
		Notizia notizia = new Notizia();
		notizia.setTesto(testo);
		testoSerializerDeserializerService.serialize(notizia);
		
		Assertions.assertEquals(expected, notizia.getTesto());
	}
	
	@Test
	void salvaNotizia() {
		GiornaleService giornaleService = new GiornaleService();
		
		String testo = "testo";
		String titolo = "titolo";
		String expectedTesto = "dGVzdG8=";
		Notizia notizia = new Notizia();
		notizia.setTesto(testo);
		notizia.setTitolo(titolo);
		
//		giornaleService.salva(notizia);
//		
//		Assertions.assertEquals(titolo, notizia.getTitolo());
//		Assertions.assertEquals(expectedTesto, notizia.getTesto());
	}
}
