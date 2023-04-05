/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.classloader.passivereference.demo3
 * @className com.cjq.jvm.classloader.passivereference.demo3.ConstClass
 * @copyright Copyright 2023 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.classloader.passivereference.demo3;

/**
 * ConstClass
 * @description 被动引用-常量类
 * @author chenjunqi
 * @date 2023年03月23日 下午8:39
 * @version 3.0.0
 */
public class ConstClass {

    public static final String string = "hello world";

    static {
        System.out.println("ConstClass init...");
    }

    public static void main(String[] args) {
        System.out.println(ConstClass.string);
    }
}
