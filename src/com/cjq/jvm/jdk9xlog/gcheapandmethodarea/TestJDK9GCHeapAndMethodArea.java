/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.jdk9xlog.gcheapandmethodarea
 * @className com.cjq.jvm.jdk9xlog.gcheapandmethodarea.TestJDK9GCHeapAndMethodArea
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.jdk9xlog.gcheapandmethodarea;

/**
 * TestJDK9GCHeapAndMethodArea
 * @description JDK9+，打印GC前后堆、方法区可用容量变化
 * @author chenjunqi
 * @date 2022年05月15日 上午10:15
 * @version 3.0.0
 */
public class TestJDK9GCHeapAndMethodArea {

    /**
     * TestJDK9GCHeapAndMethodArea
     * @description -Xlog:gc+heap=debug
     * @param args args
     * @author chenjunqi
     * @date 2022/5/15 上午10:18
     * @version 3.0.0
     */
    public static void main(String[] args) {
        System.out.println("cjq");
        System.gc();
    }
}
