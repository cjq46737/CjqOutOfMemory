/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.bytecodeengine.dynamiclanguage
 * @className com.cjq.jvm.bytecodeengine.dynamiclanguage.TestComplOrRun
 * @copyright Copyright 2023 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.bytecodeengine.dynamiclanguage;

/**
 * TestComplOrRun
 * @description 编译期或运行期进行类型检查
 * @author chenjunqi
 * @date 2023年06月15日 下午9:02
 * @version 3.0.0
 */
public class TestComplOrRun {

    public static void main(String[] args) {
        int[] a = new int[-1];
    }
}
