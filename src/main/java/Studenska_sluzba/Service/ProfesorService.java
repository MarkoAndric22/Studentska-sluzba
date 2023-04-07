package Studenska_sluzba.Service;

import java.util.List;

import Studenska_sluzba.Controlleres.util.RESTError;
import Studenska_sluzba.Entity.Profesor;
import Studenska_sluzba.Entity.DTO.ProfesorDTO;
import Studenska_sluzba.Entity.DTO.UserEntityDTO;

public interface ProfesorService {

	public ProfesorDTO addProfesor(UserEntityDTO profesor)throws RESTError;
	
	public ProfesorDTO modify(Integer id, UserEntityDTO teacheres) throws RESTError;
	
	public Profesor delete(Integer id) throws RESTError;
	

}
