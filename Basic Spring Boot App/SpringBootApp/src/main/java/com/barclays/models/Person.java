package com.barclays.models;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
//@Entity
//@Table(name="Person")
public class Person{

  //@Id
  //@NotNull
  //@Column(name="Id")
  private int id;

  //@Column(name="Name")
  private String name;

  //@Column(name="Age")
  private int age;

  public Person(){
    super();
  }

  public Person(int id, String name, int age){
    super();
    this.id = id;
    this.name = name;
    this.age = age;
  }

  public void setId(int id){
    this.id = id;
  }

  public int getId(){
    return this.id;
  }

  public void setName(String name){
    this.name = name;
  }

  public String getName(){
    return this.name;
  }

  public void setAge(int age){
    this.age = age;
  }

  public int getAge(){
    return this.age;
  }

  public String toString(){
    return "Person [ID: " + this.id +", Name: " + this.name + ", Age: " + this.age + "]";
  }

}
