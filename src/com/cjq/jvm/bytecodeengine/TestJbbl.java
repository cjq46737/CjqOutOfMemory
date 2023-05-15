/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.bytecodeengine
 * @className com.cjq.jvm.bytecodeengine.TestJbbl
 * @copyright Copyright 2023 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.bytecodeengine;

/**
 * TestJbbl
 * @description 局部变量-变量槽-复用
 * @author chenjunqi
 * @date 2023年05月06日 下午4:57
 * @version 3.0.0
 */
public class TestJbbl {

    public static void main(String[] args) {
        method2();
    }

    /**
     * TestJbbl
     * @description 变量槽不会回收，虽然作用域结束，但是没有任何变量槽的读写操作，还保留着GCRoots的关联
     * @author chenjunqi
     * @date 2023/5/15 下午8:36
     * @version 3.0.0
     */
    public static void method2() {
        {
            byte[] cc = new byte[64 * 1024 * 1024];
        }
        System.gc();
    }

    /**
     * TestJbbl
     * @description 变量槽回收
     * @author chenjunqi
     * @date 2023/5/15 下午8:38
     * @version 3.0.0
     */
    public static void method3() {
        {
            byte[] cc = new byte[64 * 1024 * 1024];
        }
        int a = 0;
        System.gc();
    }

    /**
     * TestJbbl
     * @description 变量槽不会被回收，因为gc的时候cc还在作用域中
     * @author chenjunqi
     * @date 2023/5/15 下午8:32
     * @version 3.0.0
     */
    public static void method1() {
        byte[] cc = new byte[64 * 1024 * 1024];
        System.gc();
    }

}
