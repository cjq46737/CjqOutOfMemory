/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.g1
 * @className com.cjq.jvm.g1.TestCMSOutOfVersion
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.g1;

/**
 * TestCMSOutOfVersion
 * @description 测试CMS垃圾收集器，在java9之后，被废弃。jdk调整为9+，设置虚拟机参数-XX:+UseConcMarkSweepGC.
 * @author chenjunqi
 * @date 2022年05月03日 上午9:04
 * @version 3.0.0
 */
public class TestCMSOutOfVersion {

    public static void main(String[] args) {
        System.out.println(5);
    }

}
