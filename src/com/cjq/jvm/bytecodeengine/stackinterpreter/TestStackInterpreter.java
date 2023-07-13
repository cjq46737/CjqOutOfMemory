/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.bytecodeengine.stackinterpreter
 * @className com.cjq.jvm.bytecodeengine.stackinterpreter.TestStackInterpreter
 * @copyright Copyright 2023 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.bytecodeengine.stackinterpreter;

/**
 * TestStackInterpreter
 * @description 基于栈的解释器执行过程
 * @author chenjunqi
 * @date 2023年07月10日 下午5:27
 * @version 3.0.0
 */
public class TestStackInterpreter {

    public int cal() {
        int a = 100;
        int b = 200;
        int c = 300;
        return (a + b) * c;
    }
}
