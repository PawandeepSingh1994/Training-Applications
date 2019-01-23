package com.barclays.services;

import com.barclays.models.Person;
import java.util.List;

public interface PersonService {

  public Person getPersonById(int id);
  public List<Person> getAllPersons();
  public int addPerson(Person person);
  public int removePerson(int id);

}
