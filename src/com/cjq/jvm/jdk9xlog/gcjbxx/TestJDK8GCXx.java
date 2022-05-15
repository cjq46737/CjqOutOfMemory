/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.jdk9xlog
 * @className com.cjq.jvm.jdk9xlog.jbxx.TestJDK8GCXx
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.jdk9xlog.gcjbxx;

/**
 * TestJDK8GCXx
 * @description 测试jdk9版本之前GC基本信息
 * @author chenjunqi
 * @date 2022年05月14日 下午3:44
 * @version 3.0.0
 */
public class TestJDK8GCXx {

    /**
     * TestJDK8GCXx
     * @description 设置虚拟机参数-XX:+PrintGC
     * 设置jdk版本为java8
     * @param args args
     * @author chenjunqi
     * @date 2022/5/14 下午3:51
     * @version 3.0.0
     */
    public static void main(String[] args) {
        System.out.println(8);
        System.gc();
    }
}
