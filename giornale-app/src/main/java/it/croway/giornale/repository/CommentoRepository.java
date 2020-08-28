package it.croway.giornale.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import it.croway.giornale.repository.entity.Commento;

public interface CommentoRepository extends JpaRepository<Commento, Long> {

	@Query("SELECT c FROM Commento c WHERE c.notizia.id = :notiziaId")
	public Page<Commento> findPageByNotiziaId(@Param("notiziaId") Long notiziaId, Pageable pageable);

}
