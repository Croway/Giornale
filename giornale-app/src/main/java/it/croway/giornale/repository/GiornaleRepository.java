package it.croway.giornale.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.croway.giornale.repository.entity.Notizia;

@Repository
public interface GiornaleRepository extends JpaRepository<Notizia, Long> {

	Notizia findByTitolo(String titolo);

}
