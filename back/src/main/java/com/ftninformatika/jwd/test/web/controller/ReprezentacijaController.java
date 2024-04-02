package com.ftninformatika.jwd.test.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftninformatika.jwd.test.model.Reprezentacija;
import com.ftninformatika.jwd.test.service.ReprezentacijaService;
import com.ftninformatika.jwd.test.support.ReprezentacijaToReprezentacijaDto;
import com.ftninformatika.jwd.test.web.dto.ReprezentacijaDTO;

@RestController
@RequestMapping(value = "/api/repke", produces = MediaType.APPLICATION_JSON_VALUE)
public class ReprezentacijaController {
	
	
	@Autowired
	private ReprezentacijaService repService;
	
	@Autowired
	private ReprezentacijaToReprezentacijaDto toRepDto;
	
	@GetMapping
	public ResponseEntity<List<ReprezentacijaDTO>> getAll() {
		
		List<Reprezentacija> repke = repService.findAll();
		

		return new ResponseEntity<>(toRepDto.convert(repke), HttpStatus.OK);
	}

}
