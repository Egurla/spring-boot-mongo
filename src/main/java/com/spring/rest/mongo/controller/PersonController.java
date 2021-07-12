package com.spring.rest.mongo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.spring.rest.mongo.service.Personservice;
import com.spring.rest.mongo.customExcp.PersonNotFoundException;
import com.spring.rest.mongo.model.Person;
@Component
@RestController
@RequestMapping(value = "/person")
public class PersonController {

	@Autowired
	private Personservice personservice;
	// private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping
	public Optional<Person> getById(@RequestParam(value = "id", defaultValue = "0") Optional<Integer> id,
			@RequestParam(value = "name", defaultValue = "0") Optional<String> name) throws PersonNotFoundException {
		// logger.debug("Getting person data with person id= {}.", id);
		return personservice.getByIdPerson(id.get(), name.get());
	}

	@PostMapping(value = "/addperson")
	public String create(@RequestBody Person person)
			throws PersonNotFoundException {
		// logger.debug("Saving person data.");
		personservice.createPerson(person);
		return "Person recoreds are saved";
	}

	@PutMapping(value = "/update/{id}")
	public String update(@PathVariable int id, @RequestBody Person p) {
		// logger.debug("Updating person data with id= {}.", id);
		p.setId(id);
		personservice.updatePerson(p);
		return "Person record for person= " + id + " updated.";
	}

	@DeleteMapping(value = "/{deletebyid}")
	public String deleteById(@PathVariable(value = "deletebyid") int id) {
		// logger.debug("Deleting person data with id= {}.", id);
		personservice.deletePersonById(id);
		return "Person record for person name= " + id + " deleted.";
	}

}
