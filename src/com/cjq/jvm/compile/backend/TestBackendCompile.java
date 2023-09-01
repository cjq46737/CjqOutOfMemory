/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.compile.backend
 * @className com.cjq.jvm.compile.backend.TestBackendCompile
 * @copyright Copyright 2023 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.compile.backend;

/**
 * TestBackendCompile
 * @description 测试后端编译
 * @author chenjunqi
 * @date 2023年08月23日 下午5:21
 * @version 3.0.0
 */
public class TestBackendCompile {

    private static final int NUM = 15000;

    public static int doubleValue(int i) {
        for (int j = 0; j < 100000; j++) {

        }
        return i * 2;
    }

    public static long calSum() {
        long sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += doubleValue(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        for (int i = 0; i < NUM; i++) {
            calSum();
        }
    }
}
