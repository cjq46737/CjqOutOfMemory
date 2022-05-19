/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.allocate
 * @className com.cjq.jvm.allocate.objectage.ObjectAge
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.allocate.objectage;

/**
 * ObjectAge
 * @description 测试对象的age，对象经历过n次MinorGC后进入老年代
 * @author chenjunqi
 * @date 2022年05月18日 下午8:53
 * @version 3.0.0
 */
public class ObjectAge1 {

    /**
     * 1M = 1024kb = 1024字节
     */
    private static final int _1MB = 1024 * 1024;

    /**
     * ObjectAge
     * @description MaxTenuringThreshold=1
     * @param args args
     * @author chenjunqi
     * @date 2022/5/18 下午8:58
     * @version 3.0.0
     */
    public static void main(String[] args) {
        byte[] allocation1 = new byte[_1MB / 4];
        byte[] allocation2 = new byte[_1MB * 4];
        byte[] allocation3 = new byte[_1MB * 4];
        allocation3 = null;
        allocation3 = new byte[_1MB * 4];
    }

}
