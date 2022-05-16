/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.jdk9xlog.concurrentandpausetime
 * @className com.cjq.jvm.jdk9xlog.concurrentandpausetime.TestJDK8ConcurrentAndPauseTime
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.jdk9xlog.concurrentandpausetime;

/**
 * TestJDK8ConcurrentAndPauseTime
 * @description JDK8查看GC过程，用户线程并发时间、停顿时间
 * @author chenjunqi
 * @date 2022年05月16日 下午4:32
 * @version 3.0.0
 */
public class TestJDK8ConcurrentAndPauseTime {

    /**
     * TestJDK8ConcurrentAndPauseTime
     * @description -XX:+PrintGCApplicationConcurrentTime -XX:+PrintGCAppicationStoppedTime
     * @param args args
     * @author chenjunqi
     * @date 2022/5/16 下午4:37
     * @version 3.0.0
     */
    public static void main(String[] args) {
        System.out.println("cjq is cool");
        System.gc();
    }
}
