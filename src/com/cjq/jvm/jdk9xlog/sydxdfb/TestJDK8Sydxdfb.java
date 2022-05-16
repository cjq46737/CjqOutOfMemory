/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.jdk9xlog.sydxdfb
 * @className com.cjq.jvm.jdk9xlog.sydxdfb.TestJDK8Sydxdfb
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.jdk9xlog.sydxdfb;

/**
 * TestJDK8Sydxdfb
 * @description JDK8测试剩余对象代分布情况
 * @author chenjunqi
 * @date 2022年05月16日 下午6:00
 * @version 3.0.0
 */
public class TestJDK8Sydxdfb {

    /**
     * TestJDK8Sydxdfb
     * @description -XX:+PrintTenuringDistribution
     * @param args args
     * @author chenjunqi
     * @date 2022/5/16 下午6:09
     * @version 3.0.0
     */
    public static void main(String[] args) {
        System.out.println("lsy is foolish");
        System.gc();
    }

}
