package com.barclays.axontutorial.AxonTutorialCQRS.events;

import java.util.Objects;

public class OrderPlacedEvent {

    private final String orderId;
    private final String product;

    public OrderPlacedEvent(String orderId, String product) {
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
        OrderPlacedEvent that = (OrderPlacedEvent) o;
        return Objects.equals(orderId, that.orderId) &&
                Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, product);
    }

    @Override
    public String toString() {
        return "OrderPlacedEvent{" +
                "orderId='" + orderId + '\'' +
                ", product='" + product + '\'' +
                '}';
    }
}
