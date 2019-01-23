package com.barclays.axontutorial.AxonTutorialCQRS.events;

import java.util.Objects;

public class OrderConfirmedEvent {

    private final String orderId;

    public OrderConfirmedEvent(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderConfirmedEvent that = (OrderConfirmedEvent) o;
        return Objects.equals(orderId, that.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId);
    }

    @Override
    public String toString() {
        return "OrderConfirmedEvent{" +
                "orderId='" + orderId + '\'' +
                '}';
    }
}
