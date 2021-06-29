package ITProgs.inheritance.hibernate.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ITProgs.inheritance.hibernate.entites.ParentEntity;
import ITProgs.inheritance.hibernate.repositories.ParentRepository;

@RestController
@RequestMapping(path = "api/v1/parent")
public class ParentController {

	@Autowired
	private ParentRepository parentRepository;

	@RequestMapping(method = RequestMethod.POST, path = "")
	public ResponseEntity<?> addNewParent(@RequestBody ParentEntity newParent) {
		return new ResponseEntity<ParentEntity>(parentRepository.save(newParent), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, path = "")
	public ResponseEntity<?> getAllParents() {
		return new ResponseEntity<List<ParentEntity>>((List<ParentEntity>) parentRepository.findAll(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/kill/{parentID}")
	public ResponseEntity<?> killParent(@PathVariable Long parentID) {
		ParentEntity killedParent = parentRepository.findById(parentID).get();
		parentRepository.deleteById(parentID);
		return new ResponseEntity<ParentEntity>(killedParent, HttpStatus.OK);
	}

}
