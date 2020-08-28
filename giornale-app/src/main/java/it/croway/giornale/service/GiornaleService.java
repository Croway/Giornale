package it.croway.giornale.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.croway.giornale.repository.GiornaleRepository;
import it.croway.giornale.repository.entity.Notizia;

@Service
public class GiornaleService {
	
	@Autowired
	GiornaleRepository giornaleRepository;
	
	@Autowired
	TitoloFormatterService titoloFormatterService;
	
	@Autowired
	TestoSerializerDeserializerService testoSerializerDeserializerService;

	public void salva(Notizia notizia) {
		titoloFormatterService.format(notizia);
		testoSerializerDeserializerService.serialize(notizia);
		
		notizia.setDataInserimento(LocalDateTime.now());
		notizia.setDataAggiornamento(LocalDateTime.now());
		giornaleRepository.save(notizia);
	}
	
}
