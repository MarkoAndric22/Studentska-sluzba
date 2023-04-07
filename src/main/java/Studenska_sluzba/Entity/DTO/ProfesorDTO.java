package Studenska_sluzba.Entity.DTO;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import Studenska_sluzba.Entity.City;
import Studenska_sluzba.Entity.Title;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProfesorDTO {
	@NotNull
	@Size(min = 3, max = 30)
	@Column(name = "first_name", nullable = false, length = 30)
	private String firstName;

	@NotNull
	@Size(min = 3, max = 30)
	@Column(name = "last_name", nullable = false, length = 30)
	private String lastName;

	@Email
	@Column(name = "email", unique = true, length = 30)
	private String email;

	@Size(min = 3, max = 50)
	@Column(name = "address", length = 50)
	private String address;

	@Size(min = 9, max = 15)
	@Column(name = "phone", length = 15)
	private String phone;

	@NotNull
	@Column(name = "reelection_date", nullable = false)
	private Date reelectionDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "city_id", nullable = false)
	private City city;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "title_id", nullable = false)
    private Title title;

	public ProfesorDTO(@NotNull @Size(min = 3, max = 30) String firstName,
			@NotNull @Size(min = 3, max = 30) String lastName, @Email String email,
			@Size(min = 3, max = 50) String address, @Size(min = 9, max = 15) String phone,
			@NotNull Date reelectionDate, City city, Title title) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.reelectionDate = reelectionDate;
		this.city = city;
		this.title = title;
	}

	public ProfesorDTO() {
		super();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getReelectionDate() {
		return reelectionDate;
	}

	public void setReelectionDate(Date reelectionDate) {
		this.reelectionDate = reelectionDate;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	
}
