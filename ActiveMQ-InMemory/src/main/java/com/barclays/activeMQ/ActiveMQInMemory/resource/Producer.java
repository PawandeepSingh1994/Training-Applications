package com.barclays.activeMQ.ActiveMQInMemory.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.web.bind.annotation.*;
import com.barclays.activeMQ.ActiveMQInMemory.beans.Employee;
import sun.security.krb5.internal.crypto.Des;

import javax.jms.*;

@RestController
@RequestMapping("/rest/publish")
public class Producer {

    @Autowired
    private JmsTemplate jmstemplate;

    @Autowired
    private Queue queue;


    @PostMapping()
    public String publish(@RequestBody Employee emp) {

        send(emp);

        return "Published Successfully";
    }

    public void send(Employee emp) {
        this.jmstemplate.send(this.queue, new MessageCreator(){
            public ObjectMessage createMessage(Session session) throws JMSException{
                ObjectMessage objectMessage = session.createObjectMessage(emp);
                System.out.println(objectMessage.getObject());
                return objectMessage;
            }
        });
    }

}
