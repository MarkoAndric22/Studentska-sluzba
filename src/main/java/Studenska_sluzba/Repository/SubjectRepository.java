package Studenska_sluzba.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import Studenska_sluzba.Entity.Subject;

public interface SubjectRepository extends CrudRepository<Subject, Integer> {

	List<Subject> findAllByIdIn(List<Integer> ids);
}
