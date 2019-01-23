package com.barclays.controllers;

import java.util.*;

import javax.validation.Valid;

import com.barclays.models.Person;
import com.barclays.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/persons")
@ResponseBody
public class PersonController {

  @Autowired
  PersonService personservice;

  @GetMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
  public Person getPersonById(@PathVariable("id") Integer id){
    return personservice.getPersonById(id);
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Person> getAllPersons(){
    return personservice.getAllPersons();
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  public int addPerson(@Valid @RequestBody Person person){
    return personservice.addPerson(person);
  }

  @DeleteMapping("/{id}")
  public int removePerson(@PathVariable("id") Integer id){
    return personservice.removePerson(id);
  }


}
