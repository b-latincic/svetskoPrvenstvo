package com.ftninformatika.jwd.test.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.test.model.Reprezentacija;
import com.ftninformatika.jwd.test.service.ReprezentacijaService;
import com.ftninformatika.jwd.test.web.dto.ReprezentacijaDTO;

@Component
public class ReprezentacijaToReprezentacijaDto implements Converter<Reprezentacija, ReprezentacijaDTO> {
	
	@Autowired
	private ReprezentacijaService repService;
	
	
    @Override
    public ReprezentacijaDTO convert(Reprezentacija rep) {
    	ReprezentacijaDTO dto = new ReprezentacijaDTO();
    	
    	
    	dto.setId(rep.getId());
    	dto.setNaziv(rep.getNaziv());
    	dto.setSkraceniNaziv(rep.getSkraceniNaziv());
    	
    	
    	return dto;
    	
    }

    public List<ReprezentacijaDTO> convert(List<Reprezentacija> repke){
        List<ReprezentacijaDTO> reprezentacijeDto = new ArrayList<>();
        
        for(Reprezentacija rep: repke) {
        	reprezentacijeDto.add(convert(rep));
        }
    
        return reprezentacijeDto;
    }

}
