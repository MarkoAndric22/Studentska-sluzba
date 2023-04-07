package Studenska_sluzba.mappers;

import org.springframework.stereotype.Component;

import Studenska_sluzba.Entity.Student;
import Studenska_sluzba.Entity.DTO.StudentDTO;

@Component
public class StudentMapper implements GenericMapper<Student, StudentDTO> {

	@Override
	public Student toEntity(StudentDTO dto) {
		
		return new Student(dto.getIndexNumber(),dto.getIndexYear(),dto.getFirstName(),dto.getLastName(),dto.getEmail(),dto.getAddress(),dto.getCurrentYearOfStudy());
	}

	@Override
	public StudentDTO toDto(Student entity) {
		
		return new StudentDTO(entity.getIndexNumber(),entity.getIndexYear(),entity.getFirstName(),entity.getLastName(),entity.getEmail(),entity.getAddress(),entity.getCurrentYearOfStudy());
	}

}
