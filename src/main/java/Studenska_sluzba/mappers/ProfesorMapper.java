package Studenska_sluzba.mappers;

import org.springframework.stereotype.Component;

import Studenska_sluzba.Entity.Profesor;
import Studenska_sluzba.Entity.DTO.ProfesorDTO;
@Component
public class ProfesorMapper implements GenericMapper<Profesor, ProfesorDTO> {

	@Override
	public Profesor toEntity(ProfesorDTO dto) {
		
		return new Profesor(dto.getFirstName(),dto.getLastName(),dto.getEmail(),dto.getAddress(),dto.getPhone(),dto.getReelectionDate(),dto.getCity(),dto.getTitle());
	}

	@Override
	public ProfesorDTO toDto(Profesor entity) {
		
		return new ProfesorDTO(entity.getFirstName(),entity.getLastName(),entity.getEmail(),entity.getAddress(),entity.getPhone(),entity.getReelectionDate(),entity.getCity(),entity.getTitle());
	}

}
