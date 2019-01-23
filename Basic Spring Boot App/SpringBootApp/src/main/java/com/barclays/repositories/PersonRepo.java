package com.barclays.repositories;

import java.util.*;

import org.springframework.stereotype.Repository;
import com.barclays.models.Person;

@Repository
public class PersonRepo {

  private List<Person> db = new ArrayList<>();

  public PersonRepo(){
    db.add(new Person(1, "John", 30));
    db.add(new Person(2, "Michael", 42));
    db.add(new Person(3, "Shaun", 22));
    db.add(new Person(4, "Johnson", 31));
    db.add(new Person(5, "Jonathan", 26));
    db.add(new Person(6, "Steve", 50));
  }

  public Person getPersonById(int id){
    for(Person person: this.db){
      if(id == person.getId()){
        return person;
      }
    }
    return null;
  }

  public List<Person> getAllPersons(){
    return this.db;
  }

  public int addPerson(Person person){
    this.db.add(person);
    return person.getId();
  }

  public int removePerson(int id){
    for(Person person: this.db){
      if(id == person.getId()){
        this.db.remove(person);
      }
    }
    return id;

  }


}
