package com.ftninformatika.jwd.test.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.ftninformatika.jwd.test.model.Igrac;
import com.ftninformatika.jwd.test.web.dto.IgracDTO;

@Component
public class IgracToIgracDto implements Converter<Igrac, IgracDTO> {

	@Override
	public IgracDTO convert(Igrac igrac) {

		IgracDTO dto = new IgracDTO();
		
		dto.setId(igrac.getId());
		dto.setIme(igrac.getIme());
		dto.setPostignutiGolovi(igrac.getPostignutiGolovi());
		dto.setPrezime(igrac.getPrezime());
		dto.setReprezentacijaId(igrac.getReprezentacija().getId());
		dto.setReprezentacijaNaziv(igrac.getReprezentacija().getNaziv());
		
		return dto;
	}

	
	public List<IgracDTO> convert(List<Igrac> igraci) {
		List<IgracDTO> igraciDto = new ArrayList<>();
		
		for(Igrac igrac: igraci) {
			igraciDto.add(convert(igrac));
		}
		return igraciDto;
	}


	
	
	
}
