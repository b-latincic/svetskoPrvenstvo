package com.ftninformatika.jwd.test.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ftninformatika.jwd.test.model.Igrac;

public interface IgracService {

	List<Igrac> findAll();
	
	List<Igrac> findByReprezentacijaId(Long id);
	
	Igrac findOne(Long id);
	
	Igrac update(Igrac igrac);
	
	Igrac gool(Long id);
}
