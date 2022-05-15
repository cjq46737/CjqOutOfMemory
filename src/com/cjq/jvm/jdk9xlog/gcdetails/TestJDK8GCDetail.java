/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.jdk9xlog.gcdetails
 * @className com.cjq.jvm.jdk9xlog.gcdetails.TestJDK8GCDetail
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.jdk9xlog.gcdetails;

/**
 * TestJDK8GCDetail
 * @description JDK8查看GCDetails
 * @author chenjunqi
 * @date 2022年05月15日 上午9:32
 * @version 3.0.0
 */
public class TestJDK8GCDetail {

    /**
     * TestJDK8GCDetail
     * @description 通过-XX:+PrintGCDetails参数，查看GC详细信息
     * @param args args
     * @author chenjunqi
     * @date 2022/5/15 上午9:34
     * @version 3.0.0
     */
    public static void main(String[] args) {
        System.out.println(5555);
        System.gc();
    }
}
