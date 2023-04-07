package Studenska_sluzba.Entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "professors")
public class Profesor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
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

	@OneToOne(cascade= {CascadeType.REFRESH},fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "user_id")
	@JsonIgnore
	UserEntity user;
	@JsonIgnore
	@OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ProfesorPredmet> angazovanja;

	
	public List<ProfesorPredmet> getAngazovanja() {
		return angazovanja;
	}



	public void setAngazovanja(List<ProfesorPredmet> angazovanja) {
		this.angazovanja = angazovanja;
	}



	public Profesor(Long id, @NotNull @Size(min = 3, max = 30) String firstName,
			@NotNull @Size(min = 3, max = 30) String lastName, @Email String email,
			@Size(min = 3, max = 50) String address, @Size(min = 9, max = 15) String phone,
			@NotNull Date reelectionDate, City city, Title title, UserEntity user, List<ProfesorPredmet> angazovanja) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.reelectionDate = reelectionDate;
		this.city = city;
		this.title = title;
		this.user = user;
		this.angazovanja = angazovanja;
	}



	public UserEntity getUser() {
		return user;
	}



	public void setUser(UserEntity user) {
		this.user = user;
	}



	public Profesor(Long id, @NotNull @Size(min = 3, max = 30) String firstName,
			@NotNull @Size(min = 3, max = 30) String lastName, @Email String email,
			@Size(min = 3, max = 50) String address, @Size(min = 9, max = 15) String phone,
			@NotNull Date reelectionDate, City city, Title title, UserEntity user) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.reelectionDate = reelectionDate;
		this.city = city;
		this.title = title;
		this.user = user;
	}



	public Profesor(Long id, @NotNull @Size(min = 3, max = 30) String firstName,
			@NotNull @Size(min = 3, max = 30) String lastName, @Email String email,
			@Size(min = 3, max = 50) String address, @Size(min = 9, max = 15) String phone,
			@NotNull Date reelectionDate, City city, Title title) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.reelectionDate = reelectionDate;
		this.city = city;
		this.title = title;
	}
	
	

	public Profesor(@NotNull @Size(min = 3, max = 30) String firstName,
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



	public Profesor() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
