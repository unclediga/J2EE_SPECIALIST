package ru.unclediga.spec.service;

import ru.unclediga.spec.model.TestMessage;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Stateless
public class SendMessageService {
    @Inject
    JMSContext context;
    @Resource(lookup = "jms/T1")
    Topic topic;

    public void sendText(String text) {
        String sendTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
        String propValue = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        final TestMessage testMessage = new TestMessage(sendTime, text);
        final ObjectMessage message = context.createObjectMessage(testMessage);
        try {
            message.setStringProperty("prop1", propValue);
        } catch (JMSException e) {
            e.printStackTrace();
        }
        final JMSProducer producer = context.createProducer();
        producer.send(topic, message);
    }
}
