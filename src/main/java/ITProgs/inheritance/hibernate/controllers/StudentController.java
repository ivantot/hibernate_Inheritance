package ITProgs.inheritance.hibernate.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ITProgs.inheritance.hibernate.entites.ParentEntity;
import ITProgs.inheritance.hibernate.entites.StudentEntity;
import ITProgs.inheritance.hibernate.repositories.ParentRepository;
import ITProgs.inheritance.hibernate.repositories.StudentRepository;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private ParentRepository parentRepository;

	@RequestMapping(method = RequestMethod.POST, path = "")
	public ResponseEntity<?> addNewStudent(@RequestBody StudentEntity newStudent) {
		return new ResponseEntity<StudentEntity>(studentRepository.save(newStudent), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/addParent/{studentID}/{parentID}")
	public ResponseEntity<?> addParents(@PathVariable Long studentID, @PathVariable List<Long> parentID) {
		Optional<StudentEntity> student = studentRepository.findById(studentID);
		if (student.isPresent()) {
			student.get().setParents((List<ParentEntity>) parentRepository.findAllById(parentID));
			return new ResponseEntity<StudentEntity>(studentRepository.save(student.get()), HttpStatus.OK);
		}
		return null;
	}

	@RequestMapping(method = RequestMethod.GET, path = "")
	public ResponseEntity<?> getAllStudents() {
		return new ResponseEntity<List<StudentEntity>>((List<StudentEntity>) studentRepository.findAll(),
				HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/kill/{studentID}")
	public ResponseEntity<?> killStudent(@PathVariable Long studentID) {
		StudentEntity killedStudent = studentRepository.findById(studentID).get();
		studentRepository.deleteById(studentID);
		return new ResponseEntity<StudentEntity>(killedStudent, HttpStatus.OK);
	}

}
