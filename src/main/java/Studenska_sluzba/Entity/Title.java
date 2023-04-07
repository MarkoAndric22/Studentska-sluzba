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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "titles")
public class Title {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;
    
    @OneToMany(mappedBy = "title",cascade = CascadeType.ALL)
    private List<Profesor> profesors;

	public Title(Long id, String title, List<Profesor> profesors) {
		super();
		this.id = id;
		this.title = title;
		this.profesors = profesors;
	}

	
	public Title(String title) {
		super();
		this.title = title;
	}


	public Title(String title, List<Profesor> profesors) {
		super();
		this.title = title;
		this.profesors = profesors;
	}


	public Title() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Profesor> getProfesors() {
		return profesors;
	}

	public void setProfesors(List<Profesor> profesors) {
		this.profesors = profesors;
	}
    
    
}
