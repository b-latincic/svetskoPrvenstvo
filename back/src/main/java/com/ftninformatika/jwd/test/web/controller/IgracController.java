package com.ftninformatika.jwd.test.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ftninformatika.jwd.test.model.Igrac;
import com.ftninformatika.jwd.test.service.IgracService;
import com.ftninformatika.jwd.test.support.IgracToIgracDto;
import com.ftninformatika.jwd.test.web.dto.IgracDTO;

@RestController
@RequestMapping(value="/api/igraci", produces = MediaType.APPLICATION_JSON_VALUE)
public class IgracController {
	
	@Autowired
	private IgracService igracService;
	
	@Autowired
	private IgracToIgracDto toIgracDto;
	
	@GetMapping
	public ResponseEntity<List<IgracDTO>> getAll() {
		
		List<Igrac> igraci = igracService.findAll();
		
		return new ResponseEntity<>(toIgracDto.convert(igraci), HttpStatus.OK);
		
	}
	
	@GetMapping("/strelci")
	public ResponseEntity<List<IgracDTO>> getStrelci() {
		
		List<Igrac> igraci = igracService.findAll();
		
		List<Igrac> listaStrelaca = new ArrayList<>();
		
		for(Igrac i: igraci) {
			if (i.getPostignutiGolovi() > 0) {
				listaStrelaca.add(i);
			}
		}	
		
		return new ResponseEntity<>(toIgracDto.convert(listaStrelaca), HttpStatus.OK);
		
	}
	
	
	@GetMapping("/{repId}")
	public ResponseEntity<List<IgracDTO>> getByRep(@PathVariable Long repId){
		
		List<Igrac> igraci = igracService.findByReprezentacijaId(repId);
		
		if(repId != null) {
			return new ResponseEntity<>(toIgracDto.convert(igraci), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
		
	}
	
	
	
	
	

	@PutMapping("/{id}")
	public ResponseEntity<IgracDTO> addGoal(@PathVariable Long id) {
		
		Igrac igrac = igracService.findOne(id);
		
		if(igrac == null) {
			  return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}else {
			Igrac savedIgrac = igracService.gool(id);
			
			return new ResponseEntity<>(toIgracDto.convert(savedIgrac), HttpStatus.OK);
		}
		
	}
	

}
