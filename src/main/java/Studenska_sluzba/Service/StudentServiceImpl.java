package Studenska_sluzba.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import Studenska_sluzba.Controlleres.util.RESTError;
import Studenska_sluzba.Entity.RoleEntity;
import Studenska_sluzba.Entity.Student;
import Studenska_sluzba.Entity.UserEntity;
import Studenska_sluzba.Entity.DTO.StudentDTO;
import Studenska_sluzba.Entity.DTO.UserEntityDTO;
import Studenska_sluzba.Repository.RoleRepository;
import Studenska_sluzba.Repository.StudentRepository;
import Studenska_sluzba.Repository.UserRepository;
import Studenska_sluzba.mappers.StudentMapper;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	StudentMapper studentMapper;
	
	@Override
	public StudentDTO addStudent(UserEntityDTO students) throws RESTError {
		UserEntity u=new UserEntity();
		RoleEntity r = roleRepository.findByName("ROLE_STUDENT");
		u.setName(students.getFirst_name());
		u.setLastName(students.getLastName());
		if(userRepository.findByEmail(students.getEmail()).isPresent()) {
			throw new RESTError(1, "Email must be unique");
		}
		u.setEmail(students.getEmail());
		if(userRepository.findByUsername(students.getUsername()).isPresent()) {
			throw new RESTError(1, "username must be unique");
		}
		u.setUsername(students.getUsername());
		u.setPassword(students.getPassword());
		u.setRole(r);
		Student s  = new Student();
		s.setFirstName(students.getFirst_name());
		s.setLastName(students.getLastName());
		s.setUser(u);
		
		return studentMapper.toDto(studentRepository.save(s));
	}

	@Override
	public StudentDTO modify(Integer id, UserEntityDTO students) throws RESTError {
		if(studentRepository.existsById(id)) {
			
			UserEntity u = userRepository.findByEmail(students.getEmail()).get();
			RoleEntity r = roleRepository.findByName("ROLE_STUDENT");
			u.setName(students.getFirst_name());
			u.setLastName(students.getLastName());		
			u.setPassword(students.getPassword());
			u.setRole(r);
			Student s  = studentRepository.findById(id).get();
			s.setFirstName(students.getFirst_name());
			s.setLastName(students.getLastName());
			
			s.setUser(u);
			return studentMapper.toDto(studentRepository.save(s));
		}
		throw new RESTError(1,"Students not exists");
	}

	@Override
	public Student delete(Integer id) throws RESTError {
		for(Student s : studentRepository.findAll()) {
			if(s.getId().equals(id)) {
				studentRepository.delete(s);
				Optional<UserEntity> userEntity = userRepository.findById(id);
				if(userEntity.isPresent()) {
					userRepository.delete(userEntity.get());
					return s;
				}
			}
		}
		throw new RESTError(1,"Student not exists");
	}
	

	

}
