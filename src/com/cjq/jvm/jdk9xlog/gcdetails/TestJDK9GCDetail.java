/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.jdk9xlog.gcdetails
 * @className com.cjq.jvm.jdk9xlog.gcdetails.TestJDK9GCDetail
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.jdk9xlog.gcdetails;

/**
 * TestJDK9GCDetail
 * @description JDK9+展示GC详细信息
 * @author chenjunqi
 * @date 2022年05月15日 上午9:52
 * @version 3.0.0
 */
public class TestJDK9GCDetail {

    /**
     * TestJDK9GCDetail
     * @description -Xlog:gc*显示GC详细信息
     * @param args args
     * @author chenjunqi
     * @date 2022/5/15 上午10:04
     * @version 3.0.0
     */
    public static void main(String[] args) {
        System.out.println(89);
        System.gc();
    }
}
