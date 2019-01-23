package com.barclays.messaging.standaloneactivemq.Beans;

import java.io.Serializable;

public class Employee implements Serializable {

    private static final long serialVersionUID = 9124420052100499791L;
    private int id;
    private String name;

    public Employee(){
        super();
    }

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
