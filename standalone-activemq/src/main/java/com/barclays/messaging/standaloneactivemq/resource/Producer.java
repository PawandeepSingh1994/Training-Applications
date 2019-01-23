package com.barclays.messaging.standaloneactivemq.resource;

import com.barclays.messaging.standaloneactivemq.Beans.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.web.bind.annotation.*;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.*;


@RestController
@RequestMapping("/rest/publish")
public class Producer {

    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    Queue queue;

    @PostMapping()
    public String publish(@RequestBody() Employee emp) {
        this.jmsTemplate.send(queue, new MessageCreator(){
            public ObjectMessage createMessage(Session session) throws JMSException {
                ObjectMessage objectMessage = session.createObjectMessage(emp);
                System.out.println(objectMessage.getObject());
                return objectMessage;
            }
        });
        return "Published";
    }


}
