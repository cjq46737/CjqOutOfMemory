/*
 * @projectName CjqOutOfMemory
 * @package com.jmx.client
 * @className com.jmx.client.JMXClientForOneMBean
 * @copyright Copyright 2023 Thuisoft, Inc. All rights reserved.
 */
package com.jmx.client;

import javax.management.Attribute;
import javax.management.AttributeChangeNotification;
import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

/**
 * JMXClientForOneMBean
 * @description JMX客户端-根据ObjectName获取MBean
 * @author chenjunqi
 * @date 2023年08月06日 下午2:41
 * @version 3.0.0
 */
public class JMXClientForOneMBean {

    public static void main(String[] args) throws Exception {
        String host = "127.0.0.1";
        int port = 1234;
        String url = "service:jmx:rmi:///jndi/rmi://" + host + ":" + port + "/jmxrmi";
        JMXServiceURL jmxServiceURL = new JMXServiceURL(url);
        JMXConnector connector = JMXConnectorFactory.connect(jmxServiceURL);
        MBeanServerConnection connection = connector.getMBeanServerConnection();

        ObjectName objectName = new ObjectName("com.jmx:type=hello");

        connection.addNotificationListener(objectName, (notification, handback) -> {
            System.out.println("\nReceived notification:");
            System.out.println("\tClassName: " + notification.getClass().getName());
            System.out.println("\tSource: " + notification.getSource());
            System.out.println("\tType: " + notification.getType());
            System.out.println("\tMessage: " + notification.getMessage());
            if (notification instanceof AttributeChangeNotification) {
                AttributeChangeNotification acn = (AttributeChangeNotification) notification;
                System.out.println("\tAttributeName: " + acn.getAttributeName());
                System.out.println("\tAttributeType: " + acn.getAttributeType());
                System.out.println("\tNewValue: " + acn.getNewValue());
                System.out.println("\tOldValue: " + acn.getOldValue());
            }
        }, null, null);
        Object cacheSize = connection.getAttribute(objectName, "CacheSize");
        System.out.println("Get Value: " + cacheSize);

        connection.setAttribute(objectName, new Attribute("CacheSize", 100));
        for (int i = 0; i < 5; i++)
            connection.invoke(objectName, "sayHello", null, null);
        Object result = connection.invoke(objectName, "add", new Object[] { 1, 9 },
                new String[] { int.class.getCanonicalName(), int.class.getCanonicalName() });
        System.out.println("1+9=" + result);
        Thread.sleep(Long.MAX_VALUE);
    }
}
