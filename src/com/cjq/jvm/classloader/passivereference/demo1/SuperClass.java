/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.classloader.passivereference
 * @className com.cjq.jvm.classloader.passivereference.demo1.SuperClass
 * @copyright Copyright 2023 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.classloader.passivereference.demo1;

/**
 * SuperClass
 * @description 被动应用-父类
 * @author chenjunqi
 * @date 2023年03月23日 下午7:53
 * @version 3.0.0
 */
public class SuperClass {

    public static int value = 123;

    static {
        System.out.println("superclass init....");
    }

    public static void main(String[] args) {
        // 子类引用，调用父类属性
        System.out.println(SubClass.value);
    }
}
