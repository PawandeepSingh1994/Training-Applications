package com.barclays.axontutorial.AxonTutorialCQRS.aggregates;

import com.barclays.axontutorial.AxonTutorialCQRS.commands.ConfirmOrderCommand;
import com.barclays.axontutorial.AxonTutorialCQRS.commands.PlaceOrderCommand;
import com.barclays.axontutorial.AxonTutorialCQRS.commands.ShipOrderCommand;
import com.barclays.axontutorial.AxonTutorialCQRS.events.OrderConfirmedEvent;
import com.barclays.axontutorial.AxonTutorialCQRS.events.OrderPlacedEvent;
import com.barclays.axontutorial.AxonTutorialCQRS.events.OrderShippedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;

public class OrderAggregate {

    @AggregateIdentifier
    private String orderId;

    private boolean orderConfirmed;


    public OrderAggregate() {
        super();
    }

    @CommandHandler
    public OrderAggregate(PlaceOrderCommand command) {
        AggregateLifecycle.apply(new OrderPlacedEvent(command.getOrderId(), command.getProduct()));
    }

    @CommandHandler
    public void handle(ConfirmOrderCommand command) {
        AggregateLifecycle.apply(new OrderConfirmedEvent(orderId));
    }

    @CommandHandler
    public void handle(ShipOrderCommand command) {
        if (!orderConfirmed) {
            throw new IllegalStateException("Cannot ship an order not yet confirmed!");
        }
        AggregateLifecycle.apply(new OrderShippedEvent(orderId));
    }

    @EventSourcingHandler
    public void on(OrderPlacedEvent event) {
        this.orderId = event.getOrderId();
        orderConfirmed = false;
    }

    @EventSourcingHandler
    public void on(OrderConfirmedEvent event) {
        orderConfirmed = true;
    }


}
