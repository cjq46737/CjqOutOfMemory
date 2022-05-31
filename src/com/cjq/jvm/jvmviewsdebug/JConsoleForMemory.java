/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.jvmviewsdebug
 * @className com.cjq.jvm.jvmviewsdebug.JConsoleForMemory
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.jvmviewsdebug;

import java.util.ArrayList;
import java.util.List;

/**
 * JConsoleForMemory
 * @description 不断创建对象，观察jconsole内存变化
 * @author chenjunqi
 * @date 2022年05月30日 下午9:10
 * @version 3.0.0
 */
public class JConsoleForMemory {

    /**
     * JConsoleForMemory
     * @description -Xms100m -Xmx100m -XX:+UseSerialGC
     * @param args args
     * @author chenjunqi
     * @date 2022/5/30 下午9:37
     * @version 3.0.0
     */
    public static void main(String[] args) throws InterruptedException {
        fillHeap(1000);
        System.gc();

    }

    /**
     * JConsoleForMemory
     * @description 64KB/50ms的速度向堆内存添加对象
     * @param num 添加多少个OOMObject对象
     * @author chenjunqi
     * @date 2022/5/30 下午9:15
     * @version 3.0.0
     */
    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObjecet> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            // 暂停50ms，为了让监视曲线变化跟为明显
            Thread.sleep(50);
            list.add(new OOMObjecet());
        }

    }

    /**
     * JConsoleForMemory
     * @description 静态内部类
     * @author chenjunqi
     * @date 2022/5/30 下午9:12
     * @version 3.0.0
     */
    static class OOMObjecet {

        /**
         * 用于占用内存大小，64KB
         */
        public byte[] placeholder = new byte[64 * 1024];
    }
}
