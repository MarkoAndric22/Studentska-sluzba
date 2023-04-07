package Studenska_sluzba.Service;



import Studenska_sluzba.Controlleres.util.RESTError;
import Studenska_sluzba.Entity.Student;
import Studenska_sluzba.Entity.DTO.StudentDTO;
import Studenska_sluzba.Entity.DTO.UserEntityDTO;

public interface StudentService {
	
	public StudentDTO addStudent(UserEntityDTO students)throws RESTError;
	public StudentDTO modify(Integer id, UserEntityDTO students) throws RESTError;
	public Student delete(Integer id)throws RESTError;

}
