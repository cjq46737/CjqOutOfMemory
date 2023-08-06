/*
 * @projectName CjqOutOfMemory
 * @package com.jmx
 * @className com.jmx.HelloMBean
 * @copyright Copyright 2023 Thuisoft, Inc. All rights reserved.
 */
package com.jmx;

import javax.management.AttributeChangeNotification;
import javax.management.MBeanNotificationInfo;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

/**
 * HelloMBean
 * @description MBean实现类，增加通知功能
 * @author chenjunqi
 * @date 2023年08月04日 下午5:16
 * @version 3.0.0
 */
public class Hello extends NotificationBroadcasterSupport implements HelloMBean {

    private static final String name = "cjq";

    private static final int DEFAULT_CACHE_SIZE = 200;

    private long i = 1;

    private int cacheSize = DEFAULT_CACHE_SIZE;

    @Override
    public void sayHello() {
        System.out.println("hello world");
    }

    @Override
    public int add(int x, int y) {
        return x + y;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getCacheSize() {
        return cacheSize;
    }

    @Override
    public synchronized void setCacheSize(int cacheSize) {
        int oldCacheSize = this.cacheSize;
        this.cacheSize = cacheSize;
        System.out.println("now cache size:" + this.cacheSize);

        Notification notification = new AttributeChangeNotification(this, i++, System.currentTimeMillis(),
                "oldSize:" + oldCacheSize + "newSize" + cacheSize, "cacheSize", "int", oldCacheSize, cacheSize);
        sendNotification(notification);
    }

    @Override
    public MBeanNotificationInfo[] getNotificationInfo() {
        String[] types = new String[] { AttributeChangeNotification.ATTRIBUTE_CHANGE };
        String name = AttributeChangeNotification.class.getName();
        String description = "an attribute of MBeans has changed";
        MBeanNotificationInfo mBeanNotificationInfo = new MBeanNotificationInfo(types, name, description);
        return new MBeanNotificationInfo[] { mBeanNotificationInfo };
    }
}
