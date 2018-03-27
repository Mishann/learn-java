package com.app.jmx;

import javax.management.*;
import java.lang.management.ManagementFactory;

public class App {
    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {

        ObjectName objectName = null;
        objectName = new ObjectName("com.app.jmx:type=basic,name=actionImpl");

        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        ActionImpl actionObj = new ActionImpl();

        server.registerMBean(actionObj, objectName);

        actionObj.action("Initial action");
        for (; ; ) ;

    }
}