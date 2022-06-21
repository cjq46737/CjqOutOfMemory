/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.jvmviewsdebug
 * @className com.cjq.jvm.jvmviewsdebug.JConsoleForDeadLock
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.jvmviewsdebug;

/**
 * JConsoleForDeadLock
 * @description 测试监控死锁
 * @author chenjunqi
 * @date 2022年06月01日 上午7:48
 * @version 3.0.0
 */
public class JConsoleForDeadLock {

    /**
     * JConsoleForDeadLock
     * @description 创建200个线程，死锁状态
     * @param args args
     * @author chenjunqi
     * @date 2022/6/1 上午8:11
     * @version 3.0.0
     */
    public static void main(String[] args) {
        for (int i = 0; i < 200; i++) {
            new Thread(new SyncAddRunable(1, 2)).start();
            new Thread(new SyncAddRunable(2, 1)).start();
        }
    }

    /**
     * JConsoleForDeadLock
     * @description 静态内部类，实现runnable接口，加锁求和
     * @author chenjunqi
     * @date 2022/6/1 上午8:09
     * @version 3.0.0
     */
    static class SyncAddRunable implements Runnable {

        private int a;

        private int b;

        public SyncAddRunable(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            synchronized (Integer.valueOf(a)) {
                synchronized (Integer.valueOf(b)) {
                    System.out.println(a + b);
                }
            }
        }
    }
}
