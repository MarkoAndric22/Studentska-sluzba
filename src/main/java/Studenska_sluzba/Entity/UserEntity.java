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
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class UserEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	protected Integer id;
	
	@Column(nullable=false,name = "name")
	@NotNull(message="name must be provided")
	protected String name;
	
	@Column(nullable=false,name = "last_name")
	@NotNull(message="Last name must be provided")
	protected String lastName;
	
	@Column(nullable=false, unique = true)
	@NotNull(message="username must be provided")
	@Size(min=5,max=20, message= "username must be beetwen {min} and {max} characters long.")
	protected String username;
	
	@Column(nullable=false,name="password")
	@NotNull(message="Password must be provided")
	@Size(min=5,max=100, message= "password must be beetwen {min} and {max} characters long.")
	@JsonIgnore
	protected String password;
	
	@Column(nullable=false,name = "email", unique = true)
	@NotNull(message="Email must be provided")
	@Size(min=2,max=30, message= "Email must be beetwen {min} and {max} characters long.")
	@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",
	message="Email is not valid.")
	protected String email;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
	@JoinColumn(name = "role")
	@JsonIgnore
	protected RoleEntity role;

	
	@OneToOne(mappedBy = "user", cascade = CascadeType.REFRESH)
    @PrimaryKeyJoinColumn
    @JsonIgnore
    Student student;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.REFRESH)
    @PrimaryKeyJoinColumn
    @JsonIgnore
    Profesor teacher;
	
	



	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", name=" + name + ", lastName=" + lastName + ", username=" + username
				+ ", password=" + password + ", email=" + email + "]";
	}





	public UserEntity() {
		super();
	}





	public UserEntity(Integer id, @NotNull(message = "name must be provided") String name,
			@NotNull(message = "Last name must be provided") String lastName,
			@NotNull(message = "username must be provided") @Size(min = 5, max = 20, message = "username must be beetwen {min} and {max} characters long.") String username,
			@NotNull(message = "Password must be provided") @Size(min = 5, max = 100, message = "password must be beetwen {min} and {max} characters long.") String password,
			@NotNull(message = "Email must be provided") @Size(min = 2, max = 30, message = "Email must be beetwen {min} and {max} characters long.") @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "Email is not valid.") String email,
			RoleEntity role, Student student, Profesor teacher) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
		this.student = student;
		this.teacher = teacher;
	}





	public UserEntity(@NotNull(message = "name must be provided") String name,
			@NotNull(message = "Last name must be provided") String lastName,
			@NotNull(message = "username must be provided") @Size(min = 5, max = 20, message = "username must be beetwen {min} and {max} characters long.") String username,
			@NotNull(message = "Password must be provided") @Size(min = 5, max = 100, message = "password must be beetwen {min} and {max} characters long.") String password,
			@NotNull(message = "Email must be provided") @Size(min = 2, max = 30, message = "Email must be beetwen {min} and {max} characters long.") @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "Email is not valid.") String email,
			RoleEntity role, Student student, Profesor teacher) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
		this.student = student;
		this.teacher = teacher;
	}





	public Integer getId() {
		return id;
	}





	public void setId(Integer id) {
		this.id = id;
	}





	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public String getLastName() {
		return lastName;
	}





	public void setLastName(String lastName) {
		this.lastName = lastName;
	}





	public String getUsername() {
		return username;
	}





	public void setUsername(String username) {
		this.username = username;
	}





	public String getPassword() {
		return password;
	}





	public void setPassword(String password) {
		this.password = password;
	}





	public String getEmail() {
		return email;
	}





	public void setEmail(String email) {
		this.email = email;
	}





	public RoleEntity getRole() {
		return role;
	}





	public void setRole(RoleEntity role) {
		this.role = role;
	}





	public Student getStudent() {
		return student;
	}





	public void setStudent(Student student) {
		this.student = student;
	}





	public Profesor getTeacher() {
		return teacher;
	}





	public void setTeacher(Profesor teacher) {
		this.teacher = teacher;
	}
	
	
}
