package it.croway.giornale;

import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;

import it.croway.giornale.controller.GiornaleController;
import it.croway.giornale.repository.GiornaleRepository;
import it.croway.giornale.repository.entity.Notizia;

@SpringBootTest
class GiornaleInMemoryTest {

	@Autowired
	GiornaleController giornaleController;
	
	@Autowired
	GiornaleRepository giornaleRepository;
	
	@BeforeEach
	void beforeEach() {
		giornaleRepository.deleteAll();
	}
	
	@Test
	void diIsWorking() {
		Assertions.assertNotNull(giornaleController);
	}
	
	@Test
	void testInserimento() {
		Notizia notizia = new Notizia("titolo", "testo");
		ResponseEntity<Void> re = giornaleController.salva(notizia);
		
		Assertions.assertEquals(201, re.getStatusCodeValue());
		Assertions.assertEquals(1, giornaleRepository.count());
	}
	
	@Test
	void testInserimentoERecupero() {
		String titolo = "titolo";
		Notizia notizia = new Notizia(titolo, "testo");
		giornaleController.salva(notizia);
		
		Notizia notiziaDB = giornaleController.recuperaPerTitolo(titolo);
		Assertions.assertNotNull(notiziaDB);
		Assertions.assertEquals(notiziaDB.getTitolo(), titolo);
	}
	
	@Test
	void testInserimentoERecuperaTutte() {
		int notizieSalvate = 5;
		for(int i = 0; i < notizieSalvate; i++) {
			String titolo = UUID.randomUUID().toString();
			Notizia notizia = new Notizia(titolo, "testo");
			giornaleController.salva(notizia);
		}
		
		Page<Notizia> notizie = giornaleController.recuperaTutte(PageRequest.of(0, 10));
		Assertions.assertEquals(notizieSalvate, notizie.getNumberOfElements());
	}
	
}
