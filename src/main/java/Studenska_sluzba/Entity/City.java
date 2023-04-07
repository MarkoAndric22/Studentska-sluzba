package Studenska_sluzba.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="City")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class City {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
   
	@Column(name = "postal_code", length = 5)
    private Integer postalCode;
	
	 @Column(name = "name", length = 30)
	    @Size(min = 3, message = "City name must have at least 3 characters")
	    private String name;
	   
	 @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
	 private List<Student> students;
	 
	 @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
	    private List<Profesor> profesors;

	public City(Integer postalCode, @Size(min = 3, message = "City name must have at least 3 characters") String name) {
		super();
		this.postalCode = postalCode;
		this.name = name;
	}

	public City(Long id, Integer postalCode,
			@Size(min = 3, message = "City name must have at least 3 characters") String name, List<Student> students,
			List<Profesor> profesors) {
		super();
		this.id = id;
		this.postalCode = postalCode;
		this.name = name;
		this.students = students;
		this.profesors = profesors;
	}

	public City() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Profesor> getProfesors() {
		return profesors;
	}

	public void setProfesors(List<Profesor> profesors) {
		this.profesors = profesors;
	}
	 
	 
	 
}
