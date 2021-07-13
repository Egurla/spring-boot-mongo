package com.spring.rest.mongo.service;
import java.util.Optional;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import com.spring.rest.mongo.customExcp.PersonNotFoundException;
import com.spring.rest.mongo.model.Person;

@Service
public interface Personservice {

	public void createPerson(Person person) throws PersonNotFoundException;
	public Optional<Person> getByIdPerson(Integer id,String name) throws PersonNotFoundException;
	public void deletePersonById(int id);
	public void updatePerson(Person emp);
	//Optional<Person> getByIdPerson(Integer id)
	
}
