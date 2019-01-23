package com.barclays.cqrs.EventSourcingTutorial.domainmodel.PersonAggregate;

public class LastName {

    private String lastName;

    public LastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "LastName{" +
                "lastName='" + lastName + '\'' +
                '}';
    }
}
