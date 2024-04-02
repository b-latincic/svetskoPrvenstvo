package com.ftninformatika.jwd.test.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.test.model.Utakmica;
import com.ftninformatika.jwd.test.web.dto.UtakmicaDTO;

@Component
public class UtakmicaToUtakmicaDto implements Converter<Utakmica, UtakmicaDTO>{

	@Override
	public UtakmicaDTO convert(Utakmica tekma) {


		UtakmicaDTO dto = new UtakmicaDTO();
		
		dto.setGoloviA(tekma.getGoloviA());
		dto.setGoloviB(tekma.getGoloviB());
		dto.setId(tekma.getId());
		dto.setRepANaziv(tekma.getReprezentacijaA().getNaziv());
		dto.setRepBNaziv(tekma.getReprezentacijaB().getNaziv());
		dto.setReprezentacijaAId(tekma.getReprezentacijaA().getId());
		dto.setReprezentacijaBId(tekma.getReprezentacijaB().getId());
		return dto;
	}

	public List<UtakmicaDTO> convert(List<Utakmica> tekme) {
		List<UtakmicaDTO> tekmeDto = new ArrayList<>();
		
		for(Utakmica tekma: tekme) {
			tekmeDto.add(convert(tekma));
		}
			return tekmeDto;
	}
 	
	
	
	
}
