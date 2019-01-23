package com.barclays.activeMQ.ActiveMQInMemory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class ActiveMqInMemoryApplication {

	public static void main(String[] args) {

		SpringApplication.run(ActiveMqInMemoryApplication.class, args);

	}

}

