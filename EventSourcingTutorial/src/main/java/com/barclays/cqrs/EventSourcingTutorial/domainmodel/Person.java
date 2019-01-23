package com.barclays.cqrs.EventSourcingTutorial.domainmodel;

import com.barclays.cqrs.EventSourcingTutorial.domainmodel.PersonAggregate.FirstName;
import com.barclays.cqrs.EventSourcingTutorial.domainmodel.PersonAggregate.LastName;
import com.barclays.cqrs.EventSourcingTutorial.events.PersonAdded;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import org.axonframework.eventsourcing.annotation.EventSourcingHandler;

import java.util.UUID;

public class Person extends AbstractAnnotatedAggregateRoot<UUID> {

    @AggregateIdentifier
    private UUID personId;

    private FirstName firstName;
    private LastName lastName;

    public Person() {

    }

    public Person(UUID personId, FirstName firstName, LastName lastName) {
        apply(new PersonAdded(
                personId.toString(),
                firstName.toString(),
                lastName.toString()
        ));
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId.toString() +
                ", firstName=" + firstName.toString() +
                ", lastName=" + lastName.toString() +
                '}';
    }

    @EventSourcingHandler
    public void onPersonAdded(PersonAdded event) {
        this.personId = UUID.fromString(event.getPersonId());
        this.firstName = new FirstName(event.getFirstName());
        this.lastName = new LastName(event.getLastName());
    }
}
