/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.allocate
 * @className com.cjq.jvm.allocate.AllocateBigObject
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.allocate;

/**
 * AllocateBigObject
 * @description 测试分配大对象直接进入老年代
 * @author chenjunqi
 * @date 2022年05月18日 下午5:31
 * @version 3.0.0
 */
public class AllocateBigObject {

    /**
     * 1M = 1024kb = 1024字节
     */
    private static final int _1MB = 1024 * 1024;

    /**
     * AllocateBigObject
     * @description -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:+UseSerialGC -XX:PretenureSizeThreshold=3145728
     * @param args args
     * @author chenjunqi
     * @date 2022/5/18 下午5:48
     * @version 3.0.0
     */
    public static void main(String[] args) {
        byte[] allocation4 = new byte[4 * _1MB];
    }
}
