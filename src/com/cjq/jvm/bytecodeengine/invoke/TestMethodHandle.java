/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.bytecodeengine.invoke
 * @className com.cjq.jvm.bytecodeengine.invoke.TestMethodHandle
 * @copyright Copyright 2023 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.bytecodeengine.invoke;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * TestMethodHandle
 * @description 方法句柄
 * @author chenjunqi
 * @date 2023年06月18日 上午10:20
 * @version 3.0.0
 */
public class TestMethodHandle {

    public static void main(String[] args) throws Throwable {
        Object o = System.currentTimeMillis() % 2 == 0 ? System.out : new ClassA();
        getMethodHandler(o).invokeExact("cjq is cool");
    }

    private static MethodHandle getMethodHandler(Object receiver) throws Exception {
        // 设置方法类型，第一个参数是方法的返回值类型，第二个参数方法的入参类型
        MethodType mt = MethodType.methodType(void.class, String.class);
        // 通过MethodHandles创建MethodHandle
        // 绑定：入参，方法名、方法类型
        return MethodHandles.lookup().bind(receiver, "println", mt);
    }

    static class ClassA {

        public void println(String s) {
            System.out.println("classA " + s);
        }
    }
}
