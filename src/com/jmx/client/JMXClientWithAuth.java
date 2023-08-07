/*
 * @projectName CjqOutOfMemory
 * @package com.jmx.client
 * @className com.jmx.client.JMXClientWithAuth
 * @copyright Copyright 2023 Thuisoft, Inc. All rights reserved.
 */
package com.jmx.client;

import javax.management.MBeanServerConnection;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.util.HashMap;
import java.util.Map;

/**
 * JMXClientWithAuth
 * @description JMX客户端-需要认证
 * @author chenjunqi
 * @date 2023年08月07日 下午7:59
 * @version 3.0.0
 */
public class JMXClientWithAuth {

    public static void main(String[] args) throws Exception {
        String host = "127.0.0.1";
        int port = 1234;
        String url = "service:jmx:rmi:///jndi/rmi://" + host + ":" + port + "/jmxrmi";

        Map<String, Object> params = new HashMap<>();
        params.put(JMXConnector.CREDENTIALS, new String[] { "admin", "cjq" });
        JMXServiceURL jmxServiceURL = new JMXServiceURL(url);
        JMXConnector connector = JMXConnectorFactory.connect(jmxServiceURL, params);
        MBeanServerConnection connection = connector.getMBeanServerConnection();
        Integer mBeanCount = connection.getMBeanCount();
        System.out.println(mBeanCount);
    }
}
