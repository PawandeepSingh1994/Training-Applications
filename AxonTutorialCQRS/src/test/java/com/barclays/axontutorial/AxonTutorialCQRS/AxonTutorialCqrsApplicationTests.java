package com.barclays.axontutorial.AxonTutorialCQRS;

import com.barclays.axontutorial.AxonTutorialCQRS.aggregates.OrderAggregate;
import com.barclays.axontutorial.AxonTutorialCQRS.commands.ConfirmOrderCommand;
import com.barclays.axontutorial.AxonTutorialCQRS.commands.PlaceOrderCommand;
import com.barclays.axontutorial.AxonTutorialCQRS.commands.ShipOrderCommand;
import com.barclays.axontutorial.AxonTutorialCQRS.events.OrderConfirmedEvent;
import com.barclays.axontutorial.AxonTutorialCQRS.events.OrderPlacedEvent;
import com.barclays.axontutorial.AxonTutorialCQRS.events.OrderShippedEvent;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AxonTutorialCqrsApplicationTests {

	private FixtureConfiguration<OrderAggregate> fixture;

	@Before
	public void setUp() {
		fixture = new AggregateTestFixture<>(OrderAggregate.class);
	}

	@Test
	public void TestForPlaceOrderCommand() {
		String orderId = UUID.randomUUID().toString();
		String product = "Deluxe Chair";
		fixture.givenNoPriorActivity()
				.when(new PlaceOrderCommand(orderId, product))
				.expectEvents(new OrderPlacedEvent(orderId, product));
	}

	@Test
	public void TestForOrderConfirmed() {
		String orderId = UUID.randomUUID().toString();
		String product = "Deluxe Chair";
		fixture.given(new OrderPlacedEvent(orderId, product))
				.when(new ConfirmOrderCommand(orderId))
				.expectEvents(new OrderConfirmedEvent(orderId));
	}

	@Test
	public void TestForOrderShipped() {
		String orderId = UUID.randomUUID().toString();
		String product = "Deluxe Chair";
		fixture.given(new OrderPlacedEvent(orderId, product), new OrderConfirmedEvent(orderId))
				.when(new ShipOrderCommand(orderId))
				.expectEvents(new OrderShippedEvent(orderId));
	}

	@Test
	public void TestForOrderShippedException() {
		String orderId = UUID.randomUUID().toString();
		String product = "Deluxe Chair";
		fixture.given(new OrderPlacedEvent(orderId, product))
				.when(new ShipOrderCommand(orderId))
				.expectException(IllegalStateException.class);
	}

	@Test
	public void contextLoads() {
	}

}

