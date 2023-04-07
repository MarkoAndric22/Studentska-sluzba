package Studenska_sluzba.Controlleres;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Studenska_sluzba.Repository.SubjectRepository;

@RestController
@RequestMapping(path = "/studenska_sluzba/subject")
public class SubjectController {
	
	@Autowired
	SubjectRepository subjectRepository;

}
