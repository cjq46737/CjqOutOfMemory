/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.classloader.passivereference.demo3
 * @className com.cjq.jvm.classloader.passivereference.demo3.TestClass
 * @copyright Copyright 2023 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.classloader.passivereference.demo3;

/**
 * TestClass
 * @description 被动引用-测试类
 * @author chenjunqi
 * @date 2023年03月23日 下午8:41
 * @version 3.0.0
 */
public class TestClass {

    public static void main(String[] args) {
        System.out.println(ConstClass.string);
    }

}
