package Studenska_sluzba.mappers;

import org.springframework.stereotype.Component;

import Studenska_sluzba.Entity.Title;
import Studenska_sluzba.Entity.DTO.TitleDTO;
@Component
public class TitleMapper implements GenericMapper<Title, TitleDTO> {

	@Override
	public Title toEntity(TitleDTO dto) {
		
		return new Title(dto.getTitle());
	}

	@Override
	public TitleDTO toDto(Title entity) {
		
		return new TitleDTO(entity.getTitle());
	}

}
