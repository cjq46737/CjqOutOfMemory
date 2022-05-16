/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.jdk9xlog.ergonomics
 * @className com.cjq.jvm.jdk9xlog.ergonomics.TestJDK8Ergonomics
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.jdk9xlog.ergonomics;

/**
 * TestJDK8Ergonomics
 * @description 查看JDK8的ergonomics机制
 * @author chenjunqi
 * @date 2022年05月16日 下午5:49
 * @version 3.0.0
 */
public class TestJDK8Ergonomics {

    /**
     * TestJDK8Ergonomics
     * @description -XX:+PrintAdaptiveSizePolicy
     * @param args args
     * @author chenjunqi
     * @date 2022/5/16 下午5:52
     * @version 3.0.0
     */
    public static void main(String[] args) {
        System.out.println("lsy is foolish");
        System.gc();
    }
}
