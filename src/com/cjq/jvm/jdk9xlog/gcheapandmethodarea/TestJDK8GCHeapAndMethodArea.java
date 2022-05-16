/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.jdk9xlog.gcheapandmethodarea
 * @className com.cjq.jvm.jdk9xlog.gcheapandmethodarea.TestJDK8GCHeapAndMethodArea
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.jdk9xlog.gcheapandmethodarea;

/**
 * TestJDK8GCHeapAndMethodArea
 * @description JDK8 GC前后堆、方法区可用用量变化
 * @author chenjunqi
 * @date 2022年05月15日 上午10:21
 * @version 3.0.0
 */
public class TestJDK8GCHeapAndMethodArea {

    /**
     * TestJDK8GCHeapAndMethodArea
     * @description -XX:+PrintHeapAtGC
     * @param args args
     * @author chenjunqi
     * @date 2022/5/15 上午10:24
     * @version 3.0.0
     */
    public static void main(String[] args) {
        System.out.println("lsy");
        System.gc();
    }
}
