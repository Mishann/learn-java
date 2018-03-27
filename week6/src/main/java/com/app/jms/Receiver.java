package com.app.jms;

import java.net.URISyntaxException;
import java.util.concurrent.CountDownLatch;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Receiver {
    private CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) throws URISyntaxException, Exception {
        Receiver asyncReceiveClient = new Receiver();
        asyncReceiveClient.receiveMessages();
    }

    public void receiveMessages() throws JMSException, InterruptedException {
        Connection connection = null;
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:11111");
        connection = connectionFactory.createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        try {
            Queue queue = session.createQueue("customerQueue");
            // Consumer
            MessageConsumer consumer = session.createConsumer(queue);
            ConsumerMessageListener consumerListener = new ConsumerMessageListener(
                    "Customer");
            consumer.setMessageListener(consumerListener);
            consumerListener.setReceiver(this);
            connection.start();
            latch.await();
        } finally {
            System.out.println("Received finished its work");
            if (session != null) {
                session.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public void latchCountDown() {
        latch.countDown();
    }
}