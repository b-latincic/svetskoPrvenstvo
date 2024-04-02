package com.ftninformatika.jwd.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ftninformatika.jwd.test.model.Reprezentacija;
import com.ftninformatika.jwd.test.repository.ReprezentacijaRepo;
import com.ftninformatika.jwd.test.service.ReprezentacijaService;

@Service
public class JpaReprezentacijaService implements ReprezentacijaService {

	@Autowired
	private ReprezentacijaRepo reprezentacijaRepo;
	
	@Override
	public List<Reprezentacija> findAll() {
		return reprezentacijaRepo.findAll();
	}

	@Override
	public Reprezentacija findOne(Long id) {
		return reprezentacijaRepo.findOneById(id);
	}

	
	
}
