package Studenska_sluzba.Entity.DTO;




import javax.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TitleDTO {

    @Column(name = "title", nullable = false)
    private String title;

	public TitleDTO(String title) {
		super();
		this.title = title;
	}

	public TitleDTO() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
    

}
