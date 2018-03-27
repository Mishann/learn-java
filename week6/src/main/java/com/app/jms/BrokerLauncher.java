package com.app.jms;

import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;

import java.net.URI;

public class BrokerLauncher {
    public static void main(String[] args) throws Exception {

        BrokerService broker = BrokerFactory.createBroker(new URI(
                "broker:(tcp://localhost:11111)"));
        broker.start();
    }
}
