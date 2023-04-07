package Studenska_sluzba.mappers;

import org.springframework.stereotype.Component;

import Studenska_sluzba.Entity.Subject;
import Studenska_sluzba.Entity.DTO.SubjectDTO;

@Component
public class SubjectMapper implements GenericMapper<Subject, SubjectDTO> {

	@Override
	public Subject toEntity(SubjectDTO dto) {
		
		return new Subject (dto.getName(),dto.getDescription(),dto.getNoOfESP(),dto.getYearOfStudy(),dto.getSemester());
	}

	@Override
	public SubjectDTO toDto(Subject entity) {
		
		return new SubjectDTO(entity.getName(),entity.getDescription(),entity.getNoOfESP(),entity.getYearOfStudy(),entity.getSemester());
	}

}
