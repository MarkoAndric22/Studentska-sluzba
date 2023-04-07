package Studenska_sluzba.Controlleres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Studenska_sluzba.Repository.ProfesorRepository;

@RestController
@RequestMapping(path = "/studenska_sluzba/profesor")
public class ProfesorController {
	
	@Autowired
	ProfesorRepository profesorRepository;

}
