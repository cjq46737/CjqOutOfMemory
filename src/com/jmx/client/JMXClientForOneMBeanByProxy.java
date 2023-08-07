/*
 * @projectName CjqOutOfMemory
 * @package com.jmx.client
 * @className com.jmx.client.JMXClientForOneMBeanByProxy
 * @copyright Copyright 2023 Thuisoft, Inc. All rights reserved.
 */
package com.jmx.client;

import com.jmx.HelloMBean;

import javax.management.*;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

/**
 * JMXClientForOneMBeanByProxy
 * @description JMX客户端-通过代理获取MBean
 * @author chenjunqi
 * @date 2023年08月07日 下午3:18
 * @version 3.0.0
 */
public class JMXClientForOneMBeanByProxy {

    public static void main(String[] args) throws Exception {
        String host = "127.0.0.1";
        int port = 1234;
        String url = "service:jmx:rmi:///jndi/rmi://" + host + ":" + port + "/jmxrmi";
        JMXServiceURL jmxServiceURL = new JMXServiceURL(url);
        JMXConnector connector = JMXConnectorFactory.connect(jmxServiceURL);
        MBeanServerConnection connection = connector.getMBeanServerConnection();

        ObjectName objectName = new ObjectName("com.jmx:type=hello");
        HelloMBean helloMBean = JMX.newMBeanProxy(connection, objectName, HelloMBean.class, true);

        connection.addNotificationListener(objectName, new NotificationListener() {
            @Override
            public void handleNotification(Notification notification, Object handback) {
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
            }
        }, null, null);

        System.out.println("Get Value: " + helloMBean.getCacheSize());

        helloMBean.setCacheSize(100);

        helloMBean.sayHello();
        System.out.println("1+5=" + helloMBean.add(1, 5));
        Thread.sleep(Long.MAX_VALUE);
    }
}
