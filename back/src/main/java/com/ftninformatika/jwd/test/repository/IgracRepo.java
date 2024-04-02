package com.ftninformatika.jwd.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ftninformatika.jwd.test.model.Igrac;

public interface IgracRepo extends JpaRepository<Igrac, Long> {

	Igrac findOneById(Long id);
	
	List<Igrac> findByReprezentacijaId(Long id);
}
