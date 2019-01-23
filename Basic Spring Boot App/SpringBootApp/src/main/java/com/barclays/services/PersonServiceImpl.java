package com.barclays.services;
import java.util.*;
import com.barclays.models.Person;
import com.barclays.repositories.PersonRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

  @Autowired
  PersonRepo personrepository;

  @Override
  public Person getPersonById(int id){
    return personrepository.getPersonById(id);
  }

  @Override
  public List<Person> getAllPersons(){
    return personrepository.getAllPersons();
  }

  @Override
  public int addPerson(Person person){
    return personrepository.addPerson(person);
  }

  @Override
  public int removePerson(int id){
    return personrepository.removePerson(id);
  }

}
