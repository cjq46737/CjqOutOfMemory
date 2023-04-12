/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.classloader.clinit
 * @className com.cjq.jvm.classloader.clinit.MultiThreadSafeClinit
 * @copyright Copyright 2023 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.classloader.clinit;

/**
 * MultiThreadSafeClinit
 * @description 多线程，JVM保证clinit方法的线程安全
 * @author chenjunqi
 * @date 2023年04月08日 下午2:18
 * @version 3.0.0
 */
public class MultiThreadSafeClinit {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("1.......");
                Cjq cjq = new Cjq();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("2.......");
                Cjq cjq = new Cjq();
            }
        }).start();
    }

    public static class Cjq {
        static {
            // 没有if判断，Javac编译报错
            if (true) {
                System.out.println(Thread.currentThread().getName() + " init");
                while (true) {

                }
            }

        }
    }
}
