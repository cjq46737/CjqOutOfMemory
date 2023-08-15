/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.compile.sugar.generic
 * @className com.cjq.jvm.compile.sugar.generic.TestGeneric
 * @copyright Copyright 2023 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.compile.sugar.generic;

/**
 * TestGeneric
 * @description 测试泛型，编译报错，C#不会
 * @author chenjunqi
 * @date 2023年08月11日 下午4:26
 * @version 3.0.0
 */
public class TestGeneric<E> {

    public void foo(Object args) {
        // 泛型使用，编译报错
        //        E e = new E();
        //        if (args instanceof E) {
        //
        //        }
        //        E[] arrays = new E[9];
    }
}
