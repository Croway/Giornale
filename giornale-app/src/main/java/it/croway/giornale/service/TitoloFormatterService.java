package it.croway.giornale.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import it.croway.giornale.repository.entity.Notizia;

@Service
public class TitoloFormatterService {
	
	static List<String> caratteriRiservati = new ArrayList<>();
	{
		caratteriRiservati.add(";");
		caratteriRiservati.add("/");
		caratteriRiservati.add("?");
		caratteriRiservati.add(":");
		caratteriRiservati.add("@");
		caratteriRiservati.add("&");
		caratteriRiservati.add("=");
		caratteriRiservati.add("+");
		caratteriRiservati.add("$");
		caratteriRiservati.add(",");
	}

	/**
	 * Elimina caratteri riservati e sostituisce ' ' con '_'
	 * 
	 * @param notizia
	 */
	public void format(Notizia notizia) {
		for(String carattereRiservato : caratteriRiservati) {
			notizia.setTitolo(notizia.getTitolo().replace(carattereRiservato, ""));
		}
		notizia.setTitolo(notizia.getTitolo().replace(" ", "_"));
	}
	
	public void unformat(Notizia notizia) {
		notizia.setTitolo(notizia.getTitolo().replace("_", " "));
	}
	
}
