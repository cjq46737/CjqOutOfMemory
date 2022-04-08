/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.gc
 * @className com.cjq.jvm.gc.impl.cjq
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.gc.impl;

/**
 * cjq
 * @description 测试GCRoots通过汇编命令
 * @author chenjunqi
 * @date 2022年04月07日 下午7:51
 * @version 3.0.0
 */
public class TestGCRootsHasOopMapByHB {

    private static int a = "cool".hashCode();

    /**
     * TestGCRootsByHB
     * @description 运行环境-client -Xcomp -XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly -XX:CompileCommand=compileonly
     * 主要通过打印汇编命令，来证明JVM有个OopMap的数据结构存放对象引用
     * @param args args
     * @author chenjunqi
     * @date 2022/4/7 下午9:50
     * @version 3.0.0
     */
    public static void main(String[] args) {
        System.out.println("cjq".hashCode());
        System.out.println(a);
    }
}
