/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.jstackthread
 * @className com.cjq.jvm.jstackthread.TestJstackThread
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.jstackthread;

import java.util.Map;

/**
 * TestJstackThread
 * @description 打印当前jvm所有StackTraceElement
 * @author chenjunqi
 * @date 2022年05月26日 下午9:03
 * @version 3.0.0
 */
public class TestJstackThread {

    public static void main(String[] args) {
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        for (Map.Entry<Thread, StackTraceElement[]> value : allStackTraces.entrySet()) {
            Thread thread = value.getKey();
            if (Thread.currentThread().equals(thread)) {
                continue;
            }
            for (StackTraceElement stackTraceElement : value.getValue()) {
                System.out.println(stackTraceElement + stackTraceElement.getClassName());
            }
        }

    }

}
