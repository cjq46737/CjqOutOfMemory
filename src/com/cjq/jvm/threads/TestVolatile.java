/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.threads
 * @className com.cjq.jvm.threads.TestVolatile
 * @copyright Copyright 2023 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.threads;

/**
 * TestVolatile
 * @description 基于volatile的变量运算线程不安全
 * @author chenjunqi
 * @date 2023年09月15日 下午4:45
 * @version 3.0.0
 */
public class TestVolatile {

    private static volatile int num = 0;

    private volatile boolean shutdown;

    public static void main(String[] args) {
        Thread[] threads = new Thread[20];
        for (int i = 0; i < 20; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    add();
                }
            });
            threads[i].start();
        }
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(num);
    }

    public static void add() {
        num++;
    }

    public void shutdown() {
        shutdown = true;
    }

    public void doWork() {
        if (!shutdown) {
            // do something
        }
    }

}
