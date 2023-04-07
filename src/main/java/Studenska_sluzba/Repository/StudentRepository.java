package Studenska_sluzba.Repository;

import org.springframework.data.repository.CrudRepository;

import Studenska_sluzba.Entity.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

}
