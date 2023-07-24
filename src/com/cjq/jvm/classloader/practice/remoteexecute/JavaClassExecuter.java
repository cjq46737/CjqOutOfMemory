/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.classloader.practice.remoteexecute
 * @className com.cjq.jvm.classloader.practice.remoteexecute.JavaClassExecutor
 * @copyright Copyright 2023 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.classloader.practice.remoteexecute;

import java.lang.reflect.Method;

/**
 * JavaClassExecutor
 * @description 执行类
 * @author chenjunqi
 * @date 2023年07月24日 下午5:38
 * @version 3.0.0
 */
public class JavaClassExecuter {

    public static String execute(byte[] classByte) {
        HackSystem.clearBuffer();
        ClassModifier cm = new ClassModifier(classByte);
        byte[] bytes = cm.modifyUTF8Constant("java/lang/System", "com/cjq/jvm/classloader/practiceremoteexecute");
        Class clazz = new HotSwapClassLoader().loadByte(bytes);
        try {
            Method method = clazz.getMethod("main", new Class[] { String.class });
            method.invoke(null, new String[] { null });
        } catch (Exception e) {
            e.printStackTrace(HackSystem.out);
        }
        return HackSystem.getBufferString();
    }
}
