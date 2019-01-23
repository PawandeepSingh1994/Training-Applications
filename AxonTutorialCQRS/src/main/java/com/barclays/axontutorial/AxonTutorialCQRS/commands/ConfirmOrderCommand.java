package com.barclays.axontutorial.AxonTutorialCQRS.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Objects;

public class ConfirmOrderCommand {

    @TargetAggregateIdentifier
    private final String orderId;

    public ConfirmOrderCommand(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConfirmOrderCommand that = (ConfirmOrderCommand) o;
        return Objects.equals(orderId, that.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId);
    }

    @Override
    public String toString() {
        return "ConfirmOrderCommand{" +
                "orderId='" + orderId + '\'' +
                '}';
    }
}
