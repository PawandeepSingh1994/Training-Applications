package com.barclays.cqrs.EventSourcingTutorial.events;

public class PersonAdded {

    /**
     * WHY NOT USE CUSTOM TYPES FOR FIRSTNAME AND LASTNAME?
     */

    private String personId;
    private String firstName;
    private String lastName;

    public PersonAdded(String personId, String firstName, String lastName) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
