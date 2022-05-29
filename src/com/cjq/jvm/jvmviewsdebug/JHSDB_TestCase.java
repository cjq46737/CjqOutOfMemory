/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.jvmviewsdebug
 * @className com.cjq.jvm.jvmviewsdebug.JHSDB_TestCase
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.jvmviewsdebug;

/**
 * JHSDB_TestCase
 * @description 通过JHSDB调试工具，找到对象引用的存放区域
 * @author chenjunqi
 * @date 2022年05月29日 上午10:23
 * @version 3.0.0
 */
public class JHSDB_TestCase {

    /**
     * JHSDB_TestCase
     * @description -Xmx10M -XX:+UseSerialGC -XX:-UseCompressedOops
     * 最大堆内存10M，使用串行垃圾收集器，不实用指针压缩技术
     * @param args args
     * @author chenjunqi
     * @date 2022/5/29 下午3:02
     * @version 3.0.0
     */
    public static void main(String[] args) {
        Test test = new Test();
        test.foo();
    }

    /**
     * JHSDB_TestCase
     * @description 静态内部了，分别有静态成员变量对象、普通成员变量对象、本地线程栈方法对象
     * @author chenjunqi
     * @date 2022/5/29 下午3:01
     * @version 3.0.0
     */
    static class Test {

        static ObjectHolder staticObj = new ObjectHolder();

        ObjectHolder instanceObj = new ObjectHolder();

        void foo() {
            ObjectHolder localObj = new ObjectHolder();
            System.out.println("done");
        }

    }

    /**
     * JHSDB_TestCase
     * @description 静态内部类
     * @author chenjunqi
     * @date 2022/5/29 下午3:01
     * @version 3.0.0
     */
    private static class ObjectHolder {
    }

}
