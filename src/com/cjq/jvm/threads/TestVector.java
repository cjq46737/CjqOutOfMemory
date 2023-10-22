/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.threads
 * @className com.cjq.jvm.threads.TestVector
 * @copyright Copyright 2023 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.threads;

import java.util.Vector;

/**
 * TestVector
 * @description vector线程安全，但是调用方不是线程安全的
 * @author chenjunqi
 * @date 2023年10月22日 上午9:54
 * @version 3.0.0
 */
public class TestVector {

    public static final Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {

        while (true) {
            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }
            Thread removeThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < vector.size(); i++) {
                        vector.remove(i);
                    }
                }
            });
            Thread printThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < vector.size(); i++) {
                        System.out.println(vector.get(i));
                    }
                }
            });
            removeThread.start();
            printThread.start();
            //不要同时产生过多的线程，否则会导致操作系统假死
            while (Thread.activeCount() > 20)
                ;
            System.out.println("88888888888");
        }

    }
}
