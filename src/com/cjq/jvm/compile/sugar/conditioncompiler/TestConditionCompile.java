/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.compile.sugar.conditioncompiler
 * @className com.cjq.jvm.compile.sugar.conditioncompiler.TestConditionCompile
 * @copyright Copyright 2023 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.compile.sugar.conditioncompiler;

/**
 * TestConditionCompile
 * @description 测试条件编译
 * @author chenjunqi
 * @date 2023年08月17日 下午2:18
 * @version 3.0.0
 */
public class TestConditionCompile {

    public static void main(String[] args) {
        if (true) {
            System.out.println("true...");
        } else {
            System.out.println("false...");
        }
    }

    public void f() {
        //        while (false) {
        //            System.out.println("");
        //        }
    }
}
