package com.ftninformatika.jwd.test.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ftninformatika.jwd.test.model.Utakmica;

public interface UtakmicaService {

	
	Page<Utakmica> findAll(Integer pageNo);
	
	Utakmica findOne(Long id);
	
	Page<Utakmica> search(Long repAId, Long repBId, int pageNo);
	
	
	Page<Utakmica> findAll(int pageNo);
	
	Utakmica save(Utakmica utakmica);
	
	Utakmica update(Utakmica utakmica);
	
	Utakmica delete(Long id);
	
}
