/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.bytecodeengine.dispatch
 * @className com.cjq.jvm.bytecodeengine.dispatch.TestFiledDynamicDispatch
 * @copyright Copyright 2023 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.bytecodeengine.dispatch;

/**
 * TestFiledDynamicDispatch
 * @description 字段的动态分派
 * @author chenjunqi
 * @date 2023年06月09日 下午3:08
 * @version 3.0.0
 */
public class TestFiledDynamicDispatch {

    public static void main(String[] args) {
        Father o = new Son();
        System.out.println(o.money);
    }

    static class Father {

        public int money;

        public Father() {
            money = 2;
            sayHello();

        }

        public void sayHello() {
            System.out.println("father + " + money);
        }
    }

    static class Son extends Father {
        public int money;

        public Son() {
            money = 4;
            sayHello();
        }

        public void sayHello() {
            System.out.println("son + " + money);
        }
    }
}
