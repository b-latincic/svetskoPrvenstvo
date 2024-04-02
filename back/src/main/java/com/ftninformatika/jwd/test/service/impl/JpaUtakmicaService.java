	package com.ftninformatika.jwd.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ftninformatika.jwd.test.model.Utakmica;
import com.ftninformatika.jwd.test.repository.UtakmicaRepo;
import com.ftninformatika.jwd.test.service.UtakmicaService;

@Service
public class JpaUtakmicaService implements UtakmicaService {

	@Autowired
	private UtakmicaRepo utakmicaRepo;
	
	@Override
	public Page<Utakmica> findAll(Integer pageNo) {
		return utakmicaRepo.findAll(PageRequest.of(pageNo, 3));
	}

	@Override
	public Utakmica findOne(Long id) {
		return utakmicaRepo.findOneById(id);
	}

	@Override
	public Utakmica save(Utakmica utakmica) {
		
		return utakmicaRepo.save(utakmica);
	}

	@Override
	public Utakmica update(Utakmica utakmica) {
		return utakmicaRepo.save(utakmica);	
	}

	@Override
	public Utakmica delete(Long id) {
		Utakmica utakmica = findOne(id);
		
		if(utakmica != null) {
			utakmicaRepo.delete(utakmica);
			return utakmica;
		}
		return null;
	}

	
	@Override
	public Page<Utakmica> findAll(int pageNo) {
		return utakmicaRepo.findAll(PageRequest.of(pageNo, 4));
	}
	
	
	
	
	@Override
	public Page<Utakmica> search(Long repAId, Long repBId, int pageNo) {

	
		return utakmicaRepo.search(repAId, repBId, PageRequest.of(pageNo, 4));
		
	}



}
