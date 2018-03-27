package com.app.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class ConsumerMessageListener implements MessageListener {
    private String consumerName;
    private Receiver receiver;

    public ConsumerMessageListener(String consumerName) {
        this.consumerName = consumerName;
    }

    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            System.out.println(consumerName + " received " + textMessage.getText());
            if ("END".equals(textMessage.getText())) {
                receiver.latchCountDown();
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

    public void setReceiver(Receiver receiver) {
        this.receiver = receiver;
    }
}
