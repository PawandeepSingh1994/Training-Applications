package com.barclays.axontutorial.AxonTutorialCQRS.queries;

import org.springframework.core.annotation.Order;

import java.util.Objects;

public class OrderedProduct {

    public enum OrderStatus {
        PLACED, CONFIRMED, SHIPPED
    }

    private final String orderId;
    private final String product;
    private OrderStatus orderStatus;

    public String getOrderId() {
        return orderId;
    }

    public String getProduct() {
        return product;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderedProduct that = (OrderedProduct) o;
        return Objects.equals(orderId, that.orderId) &&
                Objects.equals(product, that.product) &&
                orderStatus == that.orderStatus;
    }

    public OrderedProduct(String orderId, String product) {
        this.orderId = orderId;
        this.product = product;

        this.orderStatus = OrderStatus.PLACED;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, product, orderStatus);
    }

    public void setOrderConfirmed() {
        this.orderStatus = OrderStatus.CONFIRMED;
    }

    public void setOrderShipped() {
        this.orderStatus = OrderStatus.SHIPPED;
    }
}
