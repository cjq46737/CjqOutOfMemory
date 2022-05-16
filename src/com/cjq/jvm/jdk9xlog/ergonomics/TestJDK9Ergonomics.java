/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.jdk9xlog.ergonomics
 * @className com.cjq.jvm.jdk9xlog.ergonomics.TestJDK9Ergonomics
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.jdk9xlog.ergonomics;

/**
 * TestJDK9Ergonomics
 * @description 查看JDK9+的ergonomics机制
 * @author chenjunqi
 * @date 2022年05月16日 下午4:48
 * @version 3.0.0
 */
public class TestJDK9Ergonomics {

    /**
     * TestJDK9Ergonomics
     * @description JDK9+查看ergonimics机制（自动设置对空间各分代区域大小、收集内容等信息）。-Xlog:gc+ergo*=trace
     * @param args args
     * @author chenjunqi
     * @date 2022/5/16 下午4:53
     * @version 3.0.0
     */
    public static void main(String[] args) {
        System.out.println("lsy is foolish");
        System.gc();
    }
}
