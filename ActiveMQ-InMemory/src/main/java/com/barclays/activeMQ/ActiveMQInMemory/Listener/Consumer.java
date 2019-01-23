package com.barclays.activeMQ.ActiveMQInMemory.Listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import com.barclays.activeMQ.ActiveMQInMemory.beans.Employee;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;

@Component
public class Consumer {


    @JmsListener(destination = "inMemory.queue")
    public void listener(ObjectMessage emp) throws JMSException {

        //Employee temp = (Employee) emp.getObject();
        //System.out.println(employee);

        //System.out.println("Employee Info Recieved: " + (Employee) emp.getObject());

    }

}
