package Studenska_sluzba.mappers;


import org.springframework.stereotype.Component;

import Studenska_sluzba.Entity.City;
import Studenska_sluzba.Entity.DTO.CityDTO;

@Component
public class CityMapper implements GenericMapper<City,CityDTO> {

	@Override
	public City toEntity(CityDTO dto) {
	
		return new City(dto.getPostalCode(),dto.getName());
	}

	@Override
	public CityDTO toDto(City entity) {
		
		return new CityDTO(entity.getPostalCode(),entity.getName());
	}

}
