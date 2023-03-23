/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.bytecode
 * @className com.cjq.jvm.bytecode.TestClass
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.bytecode;

/**
 * TestClass
 * @description 测试字节码，有异常表
 * @author chenjunqi
 * @date 2022年07月14日 下午9:05
 * @version 3.0.0
 */
public class TestClassHasExceptionTable {

    public int inc() {
        int x;
        try {
            x = 1;
            return x;
        } catch (Exception e) {
            x = 2;
            return x;
        } finally {
            x = 3;
        }
    }
}
