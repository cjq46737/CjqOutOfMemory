/*
 * @projectName CjqOutOfMemory
 * @package com.jmx
 * @className com.jmx.Main
 * @copyright Copyright 2023 Thuisoft, Inc. All rights reserved.
 */
package com.jmx;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Main
 * @description 注册Mbean
 * @author chenjunqi
 * @date 2023年08月04日 下午5:24
 * @version 3.0.0
 */
public class Main {

    public static void main(String[] args) throws Exception {

        MBeanServer mbServer = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("com.jmx:type=hello");
        Hello helloMBean = new Hello();
        mbServer.registerMBean(helloMBean, name);
        System.out.println("Waiting for incoming requests...");

        new Thread(() -> {
            Random random = new Random();
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(random.nextInt(10));
                } catch (Exception e) {
                }
                helloMBean.setCacheSize(random.nextInt(10) + helloMBean.getCacheSize());
            }
        }).start();
        Thread.sleep(Long.MAX_VALUE);
    }
}
