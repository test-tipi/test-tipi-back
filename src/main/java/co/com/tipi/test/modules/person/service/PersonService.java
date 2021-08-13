package co.com.tipi.test.modules.person.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.tipi.test.modules.person.model.PersonDTO;
import co.com.tipi.test.modules.person.repository.PersonRepository;

@Service
public class PersonService {
	@Autowired
	private PersonRepository repository;
	
	public void insertPerson(PersonDTO person) throws Exception{
		repository.insertPerson(person);
	}

	public void updatePerson(PersonDTO person) throws Exception {
		repository.updatePerson(person);
		
	}

	public PersonDTO selectPerson(int id) throws Exception{
		return repository.selectPerson(id);		
	}

	public void deletePerson(PersonDTO person) throws Exception {
		repository.deletePerson(person);
	}
	
}
