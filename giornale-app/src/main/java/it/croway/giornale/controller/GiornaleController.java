package it.croway.giornale.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.annotation.Timed;
import it.croway.giornale.repository.GiornaleRepository;
import it.croway.giornale.repository.entity.Notizia;
import it.croway.giornale.service.GiornaleService;

@RestController
@RequestMapping("notizie")
public class GiornaleController {

	@Autowired
	GiornaleService giornaleService;

	@Autowired
	GiornaleRepository giornaleRepository;

	@PostMapping
	public ResponseEntity<Void> salva(Notizia notizia) {
		giornaleService.salva(notizia);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@GetMapping
	@Timed("GiornaleController.recuperaTutte")
	public Page<Notizia> recuperaTutte(Pageable pageable) {
		return giornaleRepository.findAll(pageable);
	}

	@GetMapping("{titolo}")
	@Timed("GiornaleController.recuperaTutte")
	public Notizia recuperaPerTitolo(@PathVariable("titolo") String titolo) {
		return giornaleRepository.findByTitolo(titolo);
	}

}
