package Studenska_sluzba.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import Studenska_sluzba.Entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {

	public Optional<UserEntity> findByEmail(String email);
	public Optional<UserEntity> findByUsername(String username);
}
