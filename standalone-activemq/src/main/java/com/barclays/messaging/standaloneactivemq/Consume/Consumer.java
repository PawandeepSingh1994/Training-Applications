package com.barclays.messaging.standaloneactivemq.Consume;

import com.barclays.messaging.standaloneactivemq.Beans.Employee;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.ObjectMessage;

@Component
public class Consumer {

    @JmsListener(destination = "standalone1.queue")
    public void listen(ObjectMessage emp){
        //System.out.println(text);
    }
}
