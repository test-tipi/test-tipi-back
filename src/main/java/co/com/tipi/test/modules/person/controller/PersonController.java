package co.com.tipi.test.modules.person.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.tipi.test.modules.person.model.PersonDTO;
import co.com.tipi.test.modules.person.service.PersonService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path="/person")
public class PersonController {
	
	@Autowired
	private PersonService service;
	
	@PostMapping(path = "/insert")
	public ResponseEntity<Void> insertPerson(@RequestBody PersonDTO person) {
		try {
			service.insertPerson(person);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace(System.err);
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@PostMapping(path = "/update")
	public ResponseEntity<Void> updatePerson(@RequestBody PersonDTO person) {
		try {
			service.updatePerson(person);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace(System.err);
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@GetMapping(path = "/select/{id}")
	public ResponseEntity<PersonDTO> selectPerson(@PathVariable int id) {
		try {
			PersonDTO response = service.selectPerson(id);
			return new ResponseEntity<PersonDTO>(response,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace(System.err);
			return new ResponseEntity<PersonDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@PostMapping(path = "/delete")
	public ResponseEntity<Void> deletePerson(@RequestBody PersonDTO person) {
		try {
			service.deletePerson(person);
			return new ResponseEntity<Void>(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace(System.err);
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}


}
