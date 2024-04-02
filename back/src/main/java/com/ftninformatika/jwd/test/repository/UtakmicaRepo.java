package com.ftninformatika.jwd.test.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ftninformatika.jwd.test.model.Utakmica;

public interface UtakmicaRepo extends JpaRepository<Utakmica, Long> {

	
	Utakmica findOneById(Long id);
	
	@Query("SELECT u FROM Utakmica u WHERE "
	        + "(:repA = NULL OR u.reprezentacijaA.id = :repA) AND "
	        + "(:repB = NULL OR u.reprezentacijaB.id = :repB)")
    Page<Utakmica> search (@Param("repA") Long repA,
                          @Param("repB") Long repB,
                          Pageable pageable);
	

	
	
}
