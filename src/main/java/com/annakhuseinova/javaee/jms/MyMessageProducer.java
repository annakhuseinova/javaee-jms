package com.annakhuseinova.javaee.jms;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;

@Stateless
@LocalBean
public class MyMessageProducer {

    @Resource(mappedName = "java:/queue/myQueue")
    private Queue queue;
    @Inject
    private JMSContext jmsContext;

    public void sendMessage(String message){
        jmsContext.createProducer().send(queue, message);
    }
}
