package Studenska_sluzba.utils;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import Studenska_sluzba.Entity.DTO.UserEntityDTO;



@Component
public class UserCustomValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return UserEntityDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserEntityDTO user=(UserEntityDTO) target;
		if(!user.getPassword().equals(user.getRepeatedPassword())) {
			errors.reject("400","Passwords must be the same");
		}
		
	}

}
