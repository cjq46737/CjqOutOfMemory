/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.allocate.objectage
 * @className com.cjq.jvm.allocate.objectage.DynamicObjectAge
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.allocate.objectage;

/**
 * DynamicObjectAge
 * @description 测试相同年龄对象总和大于Survivor大小一半时，直接进入老年代
 * @author chenjunqi
 * @date 2022年05月19日 下午9:22
 * @version 3.0.0
 */
public class DynamicObjectAge {

    /**
     * 1M = 1024kb = 1024字节
     */
    private static final int _1MB = 1024 * 1024;

    /**
     * ObjectAge
     * @description MaxTenuringThreshold=15
     * @param args args
     * @author chenjunqi
     * @date 2022/5/18 下午8:58
     * @version 3.0.0
     */
    public static void main(String[] args) {
        byte[] allocation0 = new byte[_1MB / 4];
        byte[] allocation1 = new byte[_1MB / 4];
        byte[] allocation2 = new byte[_1MB * 4];
        byte[] allocation3 = new byte[_1MB * 4];
        allocation3 = null;
        allocation3 = new byte[_1MB * 4];
    }

}
