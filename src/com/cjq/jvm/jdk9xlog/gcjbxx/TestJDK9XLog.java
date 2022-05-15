/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.jdk9xlog
 * @className com.cjq.jvm.jdk9xlog.jbxx.TestJDK9XLog
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.jdk9xlog.gcjbxx;

/**
 * TestJDK9XLog
 * @description 测试JDK9之后的-Xlog参数，统一HotSpot日志标准
 * @author chenjunqi
 * @date 2022年05月14日 下午3:37
 * @version 3.0.0
 */
public class TestJDK9XLog {

    /**
     * TestJDK9XLog
     * @description 设置虚拟机参数 -XLog:gc
     * 设置jdk版本为9+
     * @param args args
     * @author chenjunqi
     * @date 2022/5/14 下午3:39
     * @version 3.0.0
     */
    public static void main(String[] args) {
        System.out.println(8);
        System.gc();
    }
}
