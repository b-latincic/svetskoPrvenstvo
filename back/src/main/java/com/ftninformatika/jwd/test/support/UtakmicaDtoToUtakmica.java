package com.ftninformatika.jwd.test.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.test.model.Utakmica;
import com.ftninformatika.jwd.test.service.ReprezentacijaService;
import com.ftninformatika.jwd.test.service.UtakmicaService;
import com.ftninformatika.jwd.test.web.dto.UtakmicaDTO;

@Component
public class UtakmicaDtoToUtakmica implements Converter<UtakmicaDTO, Utakmica> {

	@Autowired
	UtakmicaService utakmicaService;

	@Autowired
	ReprezentacijaService repService;
	
	
	@Override
	public Utakmica convert(UtakmicaDTO dto) {
		
		Utakmica utakmica = null;
		
		if(dto.getId() != null) {
			utakmica = utakmicaService.findOne(dto.getId());
		}
		
		if(utakmica == null) {
			utakmica = new Utakmica();
		}
		
		utakmica.setGoloviA(dto.getGoloviA());
		utakmica.setGoloviB(dto.getGoloviB());
		utakmica.setId(dto.getId());
		utakmica.setReprezentacijaA(repService.findOne(dto.getReprezentacijaAId()));
		utakmica.setReprezentacijaB(repService.findOne(dto.getReprezentacijaBId()));
		
		return utakmica;
	}
	
	

}
