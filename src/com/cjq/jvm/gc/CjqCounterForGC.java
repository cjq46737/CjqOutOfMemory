/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.gc
 * @className com.cjq.jvm.gc.CjqCounterForGC
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.gc;

/**
 * CjqCounterForGC
 * @description 引用计数器算法，测试循环引用，-XX:PrintGCDetails。
 * @author chenjunqi
 * @date 2022年04月04日 上午9:51
 * @version 3.0.0
 */
public class CjqCounterForGC {

    private static final int _1M = 1024 * 1024;

    private Object instance = null;

    /**
     * 这个属性的作用就是占用内存，GC日志的时候查看是否回收过
     */
    private byte[] bigSize = new byte[2 * _1M];

    /**
     * CjqCounterForGC
     * @description 执行结果，对象被回收，说明JVM没有使用引用计数器GC
     * @author chenjunqi
     * @date 2022/4/4 上午11:06
     * @version 3.0.0
     */
    public static void testGc() {
        CjqCounterForGC c1 = new CjqCounterForGC();
        CjqCounterForGC c2 = new CjqCounterForGC();

        c1.instance = c2;
        c2.instance = c1;

        c1 = null;
        c2 = null;

        System.gc();
    }

    public static void main(String[] args) {
        testGc();
    }
}
