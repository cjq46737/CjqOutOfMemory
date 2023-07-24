/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.classloader.practice.remoteexecute
 * @className com.cjq.jvm.classloader.practice.remoteexecute.HotSwapClassLoader
 * @copyright Copyright 2023 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.classloader.practice.remoteexecute;

/**
 * HotSwapClassLoader
 * @description 热部署ClassLoader
 * @author chenjunqi
 * @date 2023年07月20日 下午5:26
 * @version 3.0.0
 */
public class HotSwapClassLoader extends ClassLoader {

    public HotSwapClassLoader() {
        super(HotSwapClassLoader.class.getClassLoader());
    }

    public Class loadByte(byte[] classbyte) {
        return defineClass(null, classbyte, 0, classbyte.length);
    }
}
