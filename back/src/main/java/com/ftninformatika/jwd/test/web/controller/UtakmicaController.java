package com.ftninformatika.jwd.test.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ftninformatika.jwd.test.model.Utakmica;
import com.ftninformatika.jwd.test.service.UtakmicaService;
import com.ftninformatika.jwd.test.support.UtakmicaDtoToUtakmica;
import com.ftninformatika.jwd.test.support.UtakmicaToUtakmicaDto;
import com.ftninformatika.jwd.test.web.dto.UtakmicaDTO;

@RestController
@RequestMapping(value="/api/utakmice", produces = MediaType.APPLICATION_JSON_VALUE)
public class UtakmicaController {
	
	@Autowired
	private UtakmicaService utakmicaService;
	
	@Autowired
	private UtakmicaToUtakmicaDto toTekmaDto;
	
	@Autowired
	private UtakmicaDtoToUtakmica toUtakmica;
	
	
	@GetMapping
	public ResponseEntity<List<UtakmicaDTO>> getAll(
			@RequestParam(value="pageNo", defaultValue="0") int pageNo,
			@RequestParam(required=false) Long repAId,
			@RequestParam(required=false) Long repBId) {
		
		Page<Utakmica> page = utakmicaService.search(repAId, repBId, pageNo);		
		
	    HttpHeaders headers = new HttpHeaders();
	    headers.add("Total-Pages", Integer.toString(page.getTotalPages()));

	    return new ResponseEntity<>(toTekmaDto.convert(page.getContent()), headers, HttpStatus.OK);
	}

	


	@GetMapping("/{id}")
	public ResponseEntity<UtakmicaDTO> getOne(@PathVariable Long id){
		
		Utakmica tekma = utakmicaService.findOne(id);
		
		if(tekma != null) {
			return new ResponseEntity<>(toTekmaDto.convert(tekma), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
		
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UtakmicaDTO> create(@Valid @RequestBody UtakmicaDTO utakmicaDto) {
		
		if (utakmicaDto.getReprezentacijaAId().equals(utakmicaDto.getReprezentacijaBId())) {
			return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
		}
		
		
		Utakmica utakmica = toUtakmica.convert(utakmicaDto);
		Utakmica savedUtakmica = utakmicaService.save(utakmica);
		
		return new ResponseEntity<>(toTekmaDto.convert(savedUtakmica), HttpStatus.CREATED);			
	}
	

	@PreAuthorize("hasRole('ROLE_ADMIN')")	
	@PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UtakmicaDTO> update(@PathVariable Long id, @Valid @RequestBody UtakmicaDTO utakmicaDto){
		
		if(!id.equals(utakmicaDto.getId())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Utakmica utakmica = toUtakmica.convert(utakmicaDto);
		Utakmica savedUtakmica = utakmicaService.save(utakmica);
		
		return new ResponseEntity<>(toTekmaDto.convert(savedUtakmica), HttpStatus.CREATED);		
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		Utakmica obrisanaTekma = utakmicaService.delete(id);
		
		if(obrisanaTekma != null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("/goala/{id}")
	public ResponseEntity<UtakmicaDTO> addGoalA (@PathVariable Long id, Long igracId) {
		

		Utakmica utakmica = utakmicaService.findOne(id);
		
		int goloviA = utakmica.getGoloviA();
		int noviGoloviA = goloviA + 1;
		
		utakmica.setGoloviA(noviGoloviA);
		
		Utakmica savedUtakmica = utakmicaService.update(utakmica);
		return new ResponseEntity<>(toTekmaDto.convert(savedUtakmica), HttpStatus.CREATED);	
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("/goalb/{id}")
	public ResponseEntity<UtakmicaDTO> addGoalB (@PathVariable Long id) {
		

		Utakmica utakmica = utakmicaService.findOne(id);
		
		int goloviB = utakmica.getGoloviB();
		int noviGoloviB = goloviB + 1;
		
		utakmica.setGoloviB(noviGoloviB);
		
		Utakmica savedUtakmica = utakmicaService.update(utakmica);
		return new ResponseEntity<>(toTekmaDto.convert(savedUtakmica), HttpStatus.CREATED);	
	}
	
	
	
}
