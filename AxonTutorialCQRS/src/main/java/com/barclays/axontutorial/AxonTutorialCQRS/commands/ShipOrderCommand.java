package com.barclays.axontutorial.AxonTutorialCQRS.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Objects;

public class ShipOrderCommand {

    @TargetAggregateIdentifier
    private final String orderId;

    public ShipOrderCommand(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShipOrderCommand that = (ShipOrderCommand) o;
        return Objects.equals(orderId, that.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId);
    }

    @Override
    public String toString() {
        return "ShipOrderCommand{" +
                "orderId='" + orderId + '\'' +
                '}';
    }
}
