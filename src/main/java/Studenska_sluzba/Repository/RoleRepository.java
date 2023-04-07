package Studenska_sluzba.Repository;

import org.springframework.data.repository.CrudRepository;

import Studenska_sluzba.Entity.RoleEntity;

public interface RoleRepository extends CrudRepository<RoleEntity, Integer> {

	public RoleEntity findByName(String name);
}
