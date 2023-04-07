package Studenska_sluzba.Entity.DTO;

import javax.persistence.Column;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CityDTO {
	
	@Column(name = "postal_code", length = 5)
    private Integer postalCode;
	
	 @Column(name = "name", length = 30)
	    @Size(min = 3, message = "City name must have at least 3 characters")
	    private String name;

	public CityDTO(Integer postalCode,
			@Size(min = 3, message = "City name must have at least 3 characters") String name) {
		super();
		this.postalCode = postalCode;
		this.name = name;
	}

	public CityDTO() {
		super();
	}

	public Integer getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	 
	 

}
