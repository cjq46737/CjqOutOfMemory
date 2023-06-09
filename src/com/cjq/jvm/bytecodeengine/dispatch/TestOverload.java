/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.bytecodeengine.dispatch
 * @className com.cjq.jvm.bytecodeengine.dispatch.TestOverload
 * @copyright Copyright 2023 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.bytecodeengine.dispatch;

/**
 * TestOverload
 * @description 测试方法重载-匹配优先级
 * @author chenjunqi
 * @date 2023年06月07日 下午3:37
 * @version 3.0.0
 */
public class TestOverload {

    public static void main(String[] args) {
        f('a');
    }

    //    public static void f(Serializable param) {
    //        System.out.println("serializable.....");
    //    }

    //    public static void f(Comparable comparable) {
    //        System.out.println("Comparable.....");
    //    }
    //
    //    public static void f(Object param) {
    //        System.out.println("object.....");
    //    }

    //    public static void f(int param) {
    //        System.out.println("int....");
    //    }

    //    public static void f(long param) {
    //        System.out.println("long....");
    //    }
    //
    //    public static void f(Character param) {
    //        System.out.println("Character.....");
    //    }

    //    public static void f(char param) {
    //        System.out.println("char....");
    //    }

    public static void f(char... param) {
        System.out.println("char[].....");
    }

}
