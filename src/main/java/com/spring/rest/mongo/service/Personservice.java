package com.spring.rest.mongo.service;
import java.util.Optional;

import com.spring.rest.mongo.customExcp.PersonNotFoundException;
import com.spring.rest.mongo.model.Person;
public interface Personservice {

	public void createPerson(Person person) throws PersonNotFoundException;
	public Optional<Person> getByIdPerson(Integer id,String name) throws PersonNotFoundException;
	public void deletePersonById(int id);
	public void updatePerson(Person emp);
	//Optional<Person> getByIdPerson(Integer id)
	
}
