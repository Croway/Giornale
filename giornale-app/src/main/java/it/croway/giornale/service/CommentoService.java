package it.croway.giornale.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.croway.giornale.repository.CommentoRepository;
import it.croway.giornale.repository.entity.Commento;

@Service
public class CommentoService {

	@Autowired
	IValidatoreCodiceFiscale validatoreCodiceFiscale;
	
	@Autowired
	CommentoRepository commentoRepository;

	public void validaESalva(Commento commento) {
		if (!validatoreCodiceFiscale.valida(commento.getCodiceFiscale())) {
			throw new IllegalArgumentException("cf non valido " + commento.getCodiceFiscale());
		}
		
		commentoRepository.save(commento);
	}
	
}
