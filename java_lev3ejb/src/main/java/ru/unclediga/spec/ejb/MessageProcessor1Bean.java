package ru.unclediga.spec.ejb;

import ru.unclediga.spec.model.TestMessage;
import ru.unclediga.spec.service.AppConfig;

import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(mappedName = "jms/T1")
public class MessageProcessor1Bean implements MessageListener {
    @Inject
    AppConfig config;

    @Override
    public void onMessage(Message message) {
        try {
            final TestMessage testMessage = message.getBody(TestMessage.class);
            final String prop1 = message.getStringProperty("prop1");
            config.addMessage("prop1:" + prop1 + " | t=" + testMessage.getSendTime() + " | " + testMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
