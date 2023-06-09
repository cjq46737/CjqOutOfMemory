/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.bytecodeengine.dispatch
 * @className com.cjq.jvm.bytecodeengine.dispatch.TestDynamicDispatch
 * @copyright Copyright 2023 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.bytecodeengine.dispatch;

/**
 * TestDynamicDispatch
 * @description 测试动态分派
 * @author chenjunqi
 * @date 2023年06月07日 下午4:34
 * @version 3.0.0
 */
public class TestDynamicDispatch {

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        man.sayHello();
        woman.sayHello();
        man = new Woman();
        man.sayHello();
    }

    static abstract class Human {
        public abstract void sayHello();
    }

    static class Man extends Human {

        @Override
        public void sayHello() {
            System.out.println("man .....");
        }
    }

    static class Woman extends Human {

        @Override
        public void sayHello() {
            System.out.println("woman.....");
        }
    }
}
