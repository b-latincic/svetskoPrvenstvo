package com.ftninformatika.jwd.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftninformatika.jwd.test.model.Igrac;
import com.ftninformatika.jwd.test.repository.IgracRepo;
import com.ftninformatika.jwd.test.service.IgracService;

@Service
public class JpaIgracService implements IgracService {

	@Autowired
	private IgracRepo igracRepo;
	
	@Override
	public List<Igrac> findAll() {
		return igracRepo.findAll();
	}
	
	@Override
	public Igrac findOne(Long id) {
		return igracRepo.findOneById(id);
	}

	@Override
	public List<Igrac> findByReprezentacijaId(Long id) {
		
		return igracRepo.findByReprezentacijaId(id);
	}
	
	@Override
	public Igrac update(Igrac igrac) {
		return igracRepo.save(igrac);
	}

	@Override
	public Igrac gool(Long id) {
		
		Igrac igrac = igracRepo.findOneById(id);
		
		int stariGolovi = igrac.getPostignutiGolovi();
		
		int noviGolovi = ++stariGolovi;
		
		igrac.setPostignutiGolovi(noviGolovi);
		
		update(igrac);
		
		return igrac;
	}


	
	
	
	

}
