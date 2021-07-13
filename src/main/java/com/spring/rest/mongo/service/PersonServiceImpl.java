package com.spring.rest.mongo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;

import com.spring.rest.mongo.customExcp.PersonNotFoundException;
import com.spring.rest.mongo.dao.PersonDao;
import com.spring.rest.mongo.model.Person;
@EnableMongoRepositories(basePackages = "com.spring.rest.mongo.dao")
@Component
public class PersonServiceImpl implements Personservice {

	@Autowired
	private PersonDao dao;
	boolean isvalid = false;

	/*
	 * @Autowired public void setPersonDao(PersonDao personDao) { this.dao =
	 * personDao; }
	 */
	@Override
	public void createPerson(Person person) throws PersonNotFoundException {
		isvalid = PersonServiceImpl.isValid1(person);
		try {
			if (isvalid) {

				dao.save(person);

			} else {
				throw new PersonNotFoundException("Please give valid information");
			}
		} catch (Exception e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updatePerson(Person person) {
		if (person.getName() != null) {
			dao.save(person);
		}

	}

	@Override
	public void deletePersonById(int id) {
		dao.deleteById(id);

	}

	@Override
	public Optional<Person> getByIdPerson(Integer id, String name) throws PersonNotFoundException {
		System.out.println("in person service class " + id + " " + name);
		Optional<Person> p = null;
		if (id != null || name != null) {
			p = dao.findByNameAndId(id, name);
		} else {
			throw new PersonNotFoundException("please give valid Url Id=" + id + " name=" + name);
		}
		/*
		 * if (p.isEmpty()) { throw new NullPointerException("Please valid informaton" +
		 * p.get().getId() + " " + p.get().getName()); }
		 */
		return p;

	}

	private static boolean isValid1(Person p) {
		String nameValidate = "^[a-zA-Z\\s]+$";
		String mobileNum = "[0-9]{10}";
		String line1 = "^[a-zA-Z0-9\\s]+$";
		//String pincode = "[0-9]{6}";
		String citystate = "^[a-zA-Z@#&]+$";
		if (p.getName().matches(nameValidate) && p.getMobileNumber().matches(mobileNum)
				 && p.getAddress().getLine1().matches(line1)
				&& p.getAddress().getLine2().matches(line1) && p.getAddress().getCity().matches(citystate)
				&& p.getAddress().getState().matches(citystate)) {
			return true;
		}

		/*
		 * if(p.getName().matches(nameValidate) &&
		 * p.getMobileNumber().matches(mobileNum)&&
		 * p.getAddress().getPinCode().matches(pincode)) {
		 * System.out.println("inside if "+p.getMobileNumber()+" "+p.getAddress().
		 * getPinCode()); return true; }
		 */
		return false;
	}
}
