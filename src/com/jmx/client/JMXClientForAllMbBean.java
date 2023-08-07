/*
 * @projectName CjqOutOfMemory
 * @package com.jmx.client
 * @className com.jmx.client.JMXClient
 * @copyright Copyright 2023 Thuisoft, Inc. All rights reserved.
 */
package com.jmx.client;

import javax.management.*;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.util.Set;

/**
 * JMXClient
 * @description JMX客户端-获取所有的MBean
 * @author chenjunqi
 * @date 2023年08月06日 下午2:13
 * @version 3.0.0
 */
public class JMXClientForAllMbBean {

    public static void main(String[] args) throws Exception {
        String host = "127.0.0.1";
        int port = 1234;
        String url = "service:jmx:rmi:///jndi/rmi://" + host + ":" + port + "/jmxrmi";
        JMXServiceURL jmxServiceURL = new JMXServiceURL(url);
        JMXConnector connector = JMXConnectorFactory.connect(jmxServiceURL);
        MBeanServerConnection connection = connector.getMBeanServerConnection();

        Set<ObjectName> objectNames = connection.queryNames(null, null);
        for (ObjectName objectName : objectNames) {
            System.out.println("========" + objectName + "=========");
            MBeanInfo mBeanInfo = connection.getMBeanInfo(objectName);
            System.out.println("属性：");
            for (MBeanAttributeInfo attributeInfo : mBeanInfo.getAttributes()) {
                Object value;
                try {
                    value = attributeInfo.isReadable() ? connection.getAttribute(objectName, attributeInfo.getName()) : "";
                } catch (Exception e) {
                    value = e.getMessage();
                }
                System.out.println(attributeInfo.getName() + ":" + value);
            }
            System.out.println("操作：");
            for (MBeanOperationInfo mBeanOperationInfo : mBeanInfo.getOperations()) {
                System.out.println(mBeanOperationInfo.getName() + ":" + mBeanOperationInfo.getDescription());
            }
            System.out.println("通知：");
            for (MBeanNotificationInfo mBeanNotificationInfo : mBeanInfo.getNotifications()) {
                System.out.println(mBeanNotificationInfo.getName() + ":" + mBeanNotificationInfo.getDescription());
            }
        }
        connector.close();
    }
}
