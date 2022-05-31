/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.jvmviewsdebug
 * @className com.cjq.jvm.jvmviewsdebug.JConsoleForThread
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.jvmviewsdebug;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * JConsoleForThread
 * @description TODO
 * @author chenjunqi
 * @date 2022年05月30日 下午9:51
 * @version 3.0.0
 */
public class JConsoleForThread {

    /**
     * JConsoleForThread
     * @description 启动main线程、死循环线程、wati线程
     * @param args args
     * @author chenjunqi
     * @date 2022/6/1 上午7:34
     * @version 3.0.0
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        createBusyThread();
        br.readLine();
        createLockThread(new Object());
    }

    /**
     * JConsoleForThread
     * @description 创建死循环线程
     * @author chenjunqi
     * @date 2022/6/1 上午7:30
     * @version 3.0.0
     */
    public static void createBusyThread() {
        Thread thread = new Thread(() -> {
            while (true) {

            }
        }, "test busy thread");
        thread.start();
    }

    /**
     * JConsoleForThread
     * @description 创建wait线程
     * @param lock 加锁对象
     * @author chenjunqi
     * @date 2022/6/1 上午7:30
     * @version 3.0.0
     */
    public static void createLockThread(Object lock) {
        Thread thread = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "test lock thread");
        thread.start();
    }
}
