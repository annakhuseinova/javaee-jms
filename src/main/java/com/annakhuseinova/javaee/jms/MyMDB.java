package com.annakhuseinova.javaee.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.util.logging.Logger;

/**
 * We need to provide activationConfig with all the needed activation config properties (jndi destination name,
 * destination type, acknowledgement mode)
 * for topic destination type javax.jms.Topic class is used
 * */
@MessageDriven(name = "myMDB", activationConfig = {
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "queue/myQueue"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge")
})
public class MyMDB implements MessageListener {

    private static Logger logger = Logger.getLogger(MyMDB.class.toString());

    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage){
            try {
                String text = ((TextMessage) message).getText();
                logger.info("Received message is: " + text);
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
