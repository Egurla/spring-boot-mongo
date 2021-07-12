package com.spring.rest.mongo.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.rest.mongo.model.Person;
	
@Repository
public interface PersonDao extends MongoRepository<Person, Integer> {

	//@Query("{'id': ?0 'name': ?1}")
	@Query("{$or:{id:?0},{name:?1}}")
	public Optional<Person> findByNameAndId(int id,String name);






	



	


}
