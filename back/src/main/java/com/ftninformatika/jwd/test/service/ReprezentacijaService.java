package com.ftninformatika.jwd.test.service;

import java.util.List;

import com.ftninformatika.jwd.test.model.Reprezentacija;

public interface ReprezentacijaService {

	List<Reprezentacija> findAll();
	
	Reprezentacija findOne(Long id);
	
}
