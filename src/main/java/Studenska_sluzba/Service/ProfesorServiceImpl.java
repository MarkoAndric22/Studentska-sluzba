package Studenska_sluzba.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Studenska_sluzba.Controlleres.util.RESTError;
import Studenska_sluzba.Entity.Profesor;
import Studenska_sluzba.Entity.RoleEntity;
import Studenska_sluzba.Entity.UserEntity;
import Studenska_sluzba.Entity.DTO.ProfesorDTO;
import Studenska_sluzba.Entity.DTO.UserEntityDTO;
import Studenska_sluzba.Repository.ProfesorRepository;
import Studenska_sluzba.Repository.RoleRepository;
import Studenska_sluzba.Repository.SubjectRepository;
import Studenska_sluzba.Repository.UserRepository;
import Studenska_sluzba.mappers.ProfesorMapper;


@Service
public class ProfesorServiceImpl implements ProfesorService {
	
	@Autowired
	ProfesorRepository profesorRepository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	ProfesorMapper profesorMapper;
	@Autowired
	SubjectRepository subjectRepository;
	

	@Override
	public ProfesorDTO addProfesor(UserEntityDTO profesor) throws RESTError {
		UserEntity u = new UserEntity();
		RoleEntity r = roleRepository.findByName("ROLE_TEACHER");
		u.setName(profesor.getFirst_name());
		u.setLastName(profesor.getLastName());
		if(userRepository.findByEmail(profesor.getEmail()).isPresent()) {
			throw new RESTError(1, "Email must be unique");
		}
		u.setEmail(profesor.getEmail());
		if(userRepository.findByUsername(profesor.getUsername()).isPresent()) {
			throw new RESTError(1, "username must be unique");
		}
		u.setUsername(profesor.getUsername());
		u.setPassword(profesor.getPassword());
		u.setRole(r);
		Profesor p  = new Profesor();
		p.setFirstName(profesor.getFirst_name());
		p.setLastName(profesor.getLastName());
		p.setUser(u);
		
		return profesorMapper.toDto(profesorRepository.save(p));
	}
	

	@Override
	public ProfesorDTO modify(Integer id, UserEntityDTO teacheres) throws RESTError {
		if(profesorRepository.existsById(id)) {
			UserEntity u = userRepository.findByEmail(teacheres.getEmail()).get();
			RoleEntity r = roleRepository.findByName("ROLE_TEACHER");
			u.setName(teacheres.getFirst_name());
			u.setLastName(teacheres.getLastName());		
			u.setPassword(teacheres.getPassword());
			u.setRole(r);
			Profesor p  = profesorRepository.findById(id).get();
			p.setFirstName(teacheres.getFirst_name());
			p.setLastName(teacheres.getLastName());
			
			p.setUser(u);
			return profesorMapper.toDto(profesorRepository.save(p));
		}
		throw new RESTError(1,"Teacher not exists");
	}

	@Override
	public Profesor delete(Integer id) throws RESTError {
		for(Profesor p : profesorRepository.findAll()) {
			if(p.getId().equals(id)) {
				profesorRepository.delete(p);
				Optional<UserEntity> userEntity = userRepository.findById(id);
				if(userEntity.isPresent()) {
					userRepository.delete(userEntity.get());
					return p;
				}
			}
		}
		throw new RESTError(1,"Teacher not exists");
	}

	

}
