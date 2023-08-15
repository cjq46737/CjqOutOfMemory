/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.compile.compileflow
 * @className com.cjq.jvm.compile.compileflow.CompileFlow
 * @copyright Copyright 2023 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.compile.compileflow;

/**
 * CompileFlow
 * @description 数据及控制流分析
 * @author chenjunqi
 * @date 2023年08月09日 下午2:01
 * @version 3.0.0
 */
public class CompileFlow {

    public static void main(String[] args) {
        System.out.println(4);
    }

    public void foo(final int args) {
        final int var = 0;
    }

    public void foo1(int args) {
        int var = 0;
    }

}
