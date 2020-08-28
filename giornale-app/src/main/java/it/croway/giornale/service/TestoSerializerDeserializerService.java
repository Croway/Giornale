package it.croway.giornale.service;

import java.util.Base64;

import org.springframework.stereotype.Service;

import it.croway.giornale.repository.entity.Notizia;

@Service
public class TestoSerializerDeserializerService {

	/**
	 * Serializza in Base64
	 * 
	 * @param notizia
	 */
	public void serialize(Notizia notizia) {
		notizia.setTesto(Base64.getEncoder().encodeToString(notizia.getTesto().getBytes()));
	}

	public void deserialize(Notizia notizia) {
		notizia.setTesto(new String(Base64.getDecoder().decode(notizia.getTesto().getBytes())));
	}

}
