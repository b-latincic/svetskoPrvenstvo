package com.ftninformatika.jwd.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ftninformatika.jwd.test.model.Reprezentacija;

public interface ReprezentacijaRepo extends JpaRepository<Reprezentacija, Long> {

	Reprezentacija findOneById(Long id);
	
}
