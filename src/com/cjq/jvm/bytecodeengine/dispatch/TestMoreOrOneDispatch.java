/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.bytecodeengine.dispatch
 * @className com.cjq.jvm.bytecodeengine.dispatch.TestMoreOrOneDispatch
 * @copyright Copyright 2023 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.bytecodeengine.dispatch;

/**
 * TestMoreOrOneDispatch
 * @description 多分派、单分派
 * @author chenjunqi
 * @date 2023年06月13日 下午4:33
 * @version 3.0.0
 */
public class TestMoreOrOneDispatch {

    public static void main(String[] args) {
        Father father = new Father();
        Father son = new Son();
        father.hardChoice(new _360());
        son.hardChoice(new QQ());

    }

    static class QQ {
    }

    static class _360 {
    }

    static class Father {

        public void hardChoice(QQ qq) {
            System.out.println("father qq");
        }

        public void hardChoice(_360 _360) {
            System.out.println("father 360");
        }
    }

    static class Son extends Father {
        public void hardChoice(QQ qq) {
            System.out.println("son qq");
        }

        public void hardChoice(_360 _360) {
            System.out.println("son 360");
        }
    }
}
