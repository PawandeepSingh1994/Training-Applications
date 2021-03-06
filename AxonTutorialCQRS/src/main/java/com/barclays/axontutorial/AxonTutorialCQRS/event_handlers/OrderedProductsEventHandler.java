package com.barclays.axontutorial.AxonTutorialCQRS.event_handlers;

import com.barclays.axontutorial.AxonTutorialCQRS.events.OrderConfirmedEvent;
import com.barclays.axontutorial.AxonTutorialCQRS.events.OrderPlacedEvent;
import com.barclays.axontutorial.AxonTutorialCQRS.events.OrderShippedEvent;
import com.barclays.axontutorial.AxonTutorialCQRS.queries.OrderedProduct;
import com.barclays.axontutorial.AxonTutorialCQRS.query_handlers.FindAllOrderedProductsQuery;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderedProductsEventHandler {

    private final Map<String, OrderedProduct> orderedProducts = new HashMap<>();

    @EventHandler
    public void on(OrderPlacedEvent event) {
        String orderId = event.getOrderId();
        orderedProducts.put(orderId, new OrderedProduct(orderId, event.getProduct()));
    }

    @EventHandler
    public void on(OrderConfirmedEvent event) {
        String orderId = event.getOrderId();
        orderedProducts.get(orderId).setOrderConfirmed();
    }

    @EventHandler
    public void on(OrderShippedEvent event) {
        String orderId = event.getOrderId();
        orderedProducts.get(orderId).setOrderShipped();
    }

    @QueryHandler
    public List<OrderedProduct> handle(FindAllOrderedProductsQuery query) {
        return new ArrayList<>(orderedProducts.values());
    }
}
