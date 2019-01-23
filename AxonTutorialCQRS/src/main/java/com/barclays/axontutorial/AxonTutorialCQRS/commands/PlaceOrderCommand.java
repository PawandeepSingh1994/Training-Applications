package com.barclays.axontutorial.AxonTutorialCQRS.commands;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.Objects;

public class PlaceOrderCommand {

    @TargetAggregateIdentifier
    private final String orderId;
    private final String product;

    public PlaceOrderCommand(String orderId, String product) {
        this.orderId = orderId;
        this.product = product;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getProduct() {
        return product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlaceOrderCommand that = (PlaceOrderCommand) o;
        return Objects.equals(orderId, that.orderId) &&
                Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, product);
    }

    @Override
    public String toString() {
        return "PlaceOrderCommand{" +
                "orderId='" + orderId + '\'' +
                ", product='" + product + '\'' +
                '}';
    }
}
