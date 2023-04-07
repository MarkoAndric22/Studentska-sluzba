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

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "subjects")
public class Subject {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @Column(name = "description", length = 200)
    private String description;

    @Column(name = "no_of_esp", nullable = false)
    private Integer noOfESP;

    @Column(name = "year_of_study", nullable = false)
    private Integer yearOfStudy;

    @Column(name = "semester", nullable = false, length = 10)
    private String semester;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProfesorPredmet> angazovanja;

    @JsonIgnore
	public List<ProfesorPredmet> getAngazovanja() {
		return angazovanja;
	}


	public void setAngazovanja(List<ProfesorPredmet> angazovanja) {
		this.angazovanja = angazovanja;
	}


	public Subject(Long id, String name, String description, Integer noOfESP, Integer yearOfStudy, String semester,
			List<ProfesorPredmet> angazovanja) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.noOfESP = noOfESP;
		this.yearOfStudy = yearOfStudy;
		this.semester = semester;
		this.angazovanja = angazovanja;
	}


	public Subject(Long id, String name, String description, Integer noOfESP, Integer yearOfStudy, String semester) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.noOfESP = noOfESP;
		this.yearOfStudy = yearOfStudy;
		this.semester = semester;
	}
	

	public Subject(String name, String description, Integer noOfESP, Integer yearOfStudy, String semester) {
		super();
		this.name = name;
		this.description = description;
		this.noOfESP = noOfESP;
		this.yearOfStudy = yearOfStudy;
		this.semester = semester;
	}


	public Subject() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getNoOfESP() {
		return noOfESP;
	}

	public void setNoOfESP(Integer noOfESP) {
		this.noOfESP = noOfESP;
	}

	public Integer getYearOfStudy() {
		return yearOfStudy;
	}

	public void setYearOfStudy(Integer yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

    
}

