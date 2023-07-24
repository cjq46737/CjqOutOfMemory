/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.classloader.practice.remoteexecute
 * @className com.cjq.jvm.classloader.practice.remoteexecute.HackSystem
 * @copyright Copyright 2023 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.classloader.practice.remoteexecute;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * HackSystem
 * @description 用来替换System，实现运行结果的输出
 * @author chenjunqi
 * @date 2023年07月24日 下午5:14
 * @version 3.0.0
 */
public class HackSystem {
    public static final InputStream in = System.in;

    public static final ByteArrayOutputStream buffer = new ByteArrayOutputStream();

    public static final PrintStream out = new PrintStream(buffer);

    public static final PrintStream err = out;

    public static String getBufferString() {
        return buffer.toString();
    }

    public static void clearBuffer() {
        buffer.reset();
    }

    public static SecurityManager getSecurityManager() {
        return System.getSecurityManager();
    }

    public static void setSecurityManager(final SecurityManager securityManager) {
        System.setSecurityManager(securityManager);
    }

    public static long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length) {
        System.arraycopy(src, srcPos, dest, destPos, length);
    }

    public static int identityHashCode(Object x) {
        return System.identityHashCode(x);
    }
}
