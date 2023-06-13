/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.bytecodeengine.invokemethod
 * @className com.cjq.jvm.bytecodeengine.invokemethod.TestInvokeStatic
 * @copyright Copyright 2023 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.bytecodeengine.invokemethod;

/**
 * TestInvokeStatic
 * @description 方法调用-测试调用静态方法
 * @author chenjunqi
 * @date 2023年06月05日 下午9:29
 * @version 3.0.0
 */
public class TestInvokeStatic {

    public static void sayHello() {
        System.out.println("say hello.....");
    }

    public static void main(String[] args) {
        sayHello();
    }
}
