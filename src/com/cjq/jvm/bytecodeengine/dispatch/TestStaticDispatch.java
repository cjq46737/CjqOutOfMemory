/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.bytecodeengine.dispatch
 * @className com.cjq.jvm.bytecodeengine.dispatch.TestStaticDispatch
 * @copyright Copyright 2023 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.bytecodeengine.dispatch;

/**
 * TestStaticDispatch
 * @description 测试静态分派
 * @author chenjunqi
 * @date 2023年06月06日 下午3:56
 * @version 3.0.0
 */
public class TestStaticDispatch {

    public static void main(String[] args) {

        Human human = new Man();
        new TestStaticDispatch().sayHello(human);
    }

    public void sayHello(Human human) {
        System.out.println("human........");
    }

    public void sayHello(Man man) {
        System.out.println("man........");
    }

    static abstract class Human {
    }

    static class Man extends Human {
    }
}
