/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.allocate
 * @className com.cjq.jvm.allocate.AllocateNewObject
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.allocate;

/**
 * AllocateNewObject
 * @description 测试新生对象分配在eden区，eden区没有足够空间的时候触发minor gc
 * @author chenjunqi
 * @date 2022年05月17日 下午8:48
 * @version 3.0.0
 */
public class AllocateNewObject {

    /**
     * 1M = 1024kb = 1024字节
     */
    private static final int _1MB = 1024 * 1024;

    /**
     * AllocateNewObject
     * @description 指定虚拟机参数，测试对象分配在新生代
     * -XX:+PrintGCDetails -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:+UseSerialGC
     * -XX:SurvivorRatio=8可以不写，默认也是8
     * @author chenjunqi
     * @date 2022/5/17 下午9:03
     * @version 3.0.0
     */
    public static void testAllocation() {
        byte[] allocation1 = new byte[2 * _1MB];
        byte[] allocation2 = new byte[2 * _1MB];
        byte[] allocation3 = new byte[2 * _1MB];
        byte[] allocation4 = new byte[4 * _1MB];
    }

    public static void main(String[] args) {
        testAllocation();
    }

}
