package Studenska_sluzba.Entity;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="students")
public class Student {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id")
		private Long id;
	
		@Column(name = "index_number", nullable = false, unique = true, length = 4)
	    @Size(min = 4, max = 4, message = "Index number must have exact 4 characters")
	    private String indexNumber;
		
		@Column(name = "index_year", nullable = false, unique = true)
		@Min(value = 2000, message = "Index year cannot be less than 2000")
		@Max(value = 2100, message = "Index year cannot be greater than 2100")
		private Integer indexYear;
		
		@Column(name = "first_name", nullable = false, length = 30)
	    @NotBlank(message = "First name cannot be blank")
	    @Size(min = 3, message = "First name must have at least 3 characters")
	    private String firstName;
		
		@Column(name = "last_name", nullable = false, length = 30)
		@NotBlank(message = "Last name cannot be blank")
	    @Size(min = 3, message = "Last name must have at least 3 characters")
	    private String lastName;
		
	    @Column(name = "email", length = 30, unique = true)
	    @Pattern(regexp = ".+@.+\\..+", message = "Email must contain @ character")
	    @Email(message = "Email should be valid")
	    private String email;
	    
	    @Column(name = "address", length = 50)
	    @Size(min = 3, message = "Address must have at least 3 characters")
	    private String address;


	    @Column(name = "current_year_of_study")
	    private Integer currentYearOfStudy;
	    
		@OneToOne(cascade= {CascadeType.REFRESH},fetch = FetchType.LAZY)
	    @MapsId
	    @JoinColumn(name = "user_id")
		@JsonIgnore
		UserEntity user;
	    
	    @ManyToOne
	    @JoinColumn(name = "city_id")
	    private City city;

	    
		public UserEntity getUser() {
			return user;
		}


		public void setUser(UserEntity user) {
			this.user = user;
		}


		public Student(Long id,
				@Size(min = 4, max = 4, message = "Index number must have exact 4 characters") String indexNumber,
				@Min(value = 2000, message = "Index year cannot be less than 2000") @Max(value = 2100, message = "Index year cannot be greater than 2100") Integer indexYear,
				@NotBlank(message = "First name cannot be blank") @Size(min = 3, message = "First name must have at least 3 characters") String firstName,
				@NotBlank(message = "Last name cannot be blank") @Size(min = 3, message = "Last name must have at least 3 characters") String lastName,
				@Pattern(regexp = ".+@.+\\..+", message = "Email must contain @ character") @Email(message = "Email should be valid") String email,
				@Size(min = 3, message = "Address must have at least 3 characters") String address,
				Integer currentYearOfStudy, UserEntity user, City city) {
			super();
			this.id = id;
			this.indexNumber = indexNumber;
			this.indexYear = indexYear;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.address = address;
			this.currentYearOfStudy = currentYearOfStudy;
			this.user = user;
			this.city = city;
		}


		public Student(Long id,
				@Size(min = 4, max = 4, message = "Index number must have exact 4 characters") String indexNumber,
				@Min(value = 2000, message = "Index year cannot be less than 2000") @Max(value = 2100, message = "Index year cannot be greater than 2100") Integer indexYear,
				@NotBlank(message = "First name cannot be blank") @Size(min = 3, message = "First name must have at least 3 characters") String firstName,
				@NotBlank(message = "Last name cannot be blank") @Size(min = 3, message = "Last name must have at least 3 characters") String lastName,
				@Pattern(regexp = ".+@.+\\..+", message = "Email must contain @ character") @Email(message = "Email should be valid") String email,
				@Size(min = 3, message = "Address must have at least 3 characters") String address,
				Integer currentYearOfStudy, City city) {
			super();
			this.id = id;
			this.indexNumber = indexNumber;
			this.indexYear = indexYear;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.address = address;
			this.currentYearOfStudy = currentYearOfStudy;
			this.city = city;
		}
		

		public Student(
				@Size(min = 4, max = 4, message = "Index number must have exact 4 characters") String indexNumber,
				@Min(value = 2000, message = "Index year cannot be less than 2000") @Max(value = 2100, message = "Index year cannot be greater than 2100") Integer indexYear,
				@NotBlank(message = "First name cannot be blank") @Size(min = 3, message = "First name must have at least 3 characters") String firstName,
				@NotBlank(message = "Last name cannot be blank") @Size(min = 3, message = "Last name must have at least 3 characters") String lastName,
				@Pattern(regexp = ".+@.+\\..+", message = "Email must contain @ character") @Email(message = "Email should be valid") String email,
				@Size(min = 3, message = "Address must have at least 3 characters") String address,
				Integer currentYearOfStudy, City city) {
			super();
			this.indexNumber = indexNumber;
			this.indexYear = indexYear;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.address = address;
			this.currentYearOfStudy = currentYearOfStudy;
			this.city = city;
		}


		public Student(
				@Size(min = 4, max = 4, message = "Index number must have exact 4 characters") String indexNumber,
				@Min(value = 2000, message = "Index year cannot be less than 2000") @Max(value = 2100, message = "Index year cannot be greater than 2100") Integer indexYear,
				@NotBlank(message = "First name cannot be blank") @Size(min = 3, message = "First name must have at least 3 characters") String firstName,
				@NotBlank(message = "Last name cannot be blank") @Size(min = 3, message = "Last name must have at least 3 characters") String lastName,
				@Pattern(regexp = ".+@.+\\..+", message = "Email must contain @ character") @Email(message = "Email should be valid") String email,
				@Size(min = 3, message = "Address must have at least 3 characters") String address,
				Integer currentYearOfStudy) {
			super();
			this.indexNumber = indexNumber;
			this.indexYear = indexYear;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.address = address;
			this.currentYearOfStudy = currentYearOfStudy;
		}


		public Student() {
			super();
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getIndexNumber() {
			return indexNumber;
		}

		public void setIndexNumber(String indexNumber) {
			this.indexNumber = indexNumber;
		}

		public Integer getIndexYear() {
			return indexYear;
		}

		public void setIndexYear(Integer indexYear) {
			this.indexYear = indexYear;
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

		public Integer getCurrentYearOfStudy() {
			return currentYearOfStudy;
		}

		public void setCurrentYearOfStudy(Integer currentYearOfStudy) {
			this.currentYearOfStudy = currentYearOfStudy;
		}

		public City getCity() {
			return city;
		}

		public void setCity(City city) {
			this.city = city;
		}
	    
	    
}
