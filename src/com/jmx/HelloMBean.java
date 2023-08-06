/*
 * @projectName CjqOutOfMemory
 * @package com.jmx
 * @className com.jmx.IHelloMBean
 * @copyright Copyright 2023 Thuisoft, Inc. All rights reserved.
 */
package com.jmx;

/**
 * IHelloMBean
 * @description MBean接口
 * @author chenjunqi
 * @date 2023年08月04日 下午5:07
 * @version 3.0.0
 */
public interface HelloMBean {

    void sayHello();

    int add(int x, int y);

    String getName();

    int getCacheSize();

    void setCacheSize(int cacheSize);
}
