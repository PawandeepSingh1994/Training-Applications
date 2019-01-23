package com.barclays.axontutorial.AxonTutorialCQRS.controllers;

import com.barclays.axontutorial.AxonTutorialCQRS.commands.ConfirmOrderCommand;
import com.barclays.axontutorial.AxonTutorialCQRS.commands.PlaceOrderCommand;
import com.barclays.axontutorial.AxonTutorialCQRS.commands.ShipOrderCommand;
import com.barclays.axontutorial.AxonTutorialCQRS.queries.OrderedProduct;
import com.barclays.axontutorial.AxonTutorialCQRS.query_handlers.FindAllOrderedProductsQuery;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class OrderRestEndpoint {


    private final CommandGateway commandGateway;


    private final QueryGateway queryGateway;

    public OrderRestEndpoint(CommandGateway commandGateway, QueryGateway queryGateway) {
        this.commandGateway = commandGateway;
        this.queryGateway = queryGateway;
    }

    @GetMapping("/all-orders")
    public List<OrderedProduct> findAllOrderedProducts() {
        return queryGateway.query(new FindAllOrderedProductsQuery(), ResponseTypes.multipleInstancesOf(OrderedProduct.class)).join();
    }

    @PostMapping("/ship-order")
    public void shipOrder() {
        String orderId = UUID.randomUUID().toString();
        commandGateway.send(new PlaceOrderCommand(orderId, "Deluxe Chair"));
        commandGateway.send(new ConfirmOrderCommand(orderId));
        commandGateway.send(new ShipOrderCommand(orderId));
    }


}
