/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.classloader.classloader
 * @className com.cjq.jvm.classloader.classloader.CjqClassLoader
 * @copyright Copyright 2023 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.classloader.classloader;

import java.io.IOException;
import java.io.InputStream;

/**
 * CjqClassLoader
 * @description 一个JVM，多个classloader
 * @author chenjunqi
 * @date 2023年04月12日 下午8:47
 * @version 3.0.0
 */
public class CjqClassLoader {

    public static void main(String[] args) throws Exception {
        ClassLoader cjqClassLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {

                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] bytes = new byte[is.available()];
                    is.read(bytes);
                    return defineClass(name, bytes, 0, bytes.length);
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new ClassNotFoundException();
                }
            }
        };

        Object o = cjqClassLoader.loadClass("com.cjq.jvm.classloader.classloader.CjqClassLoader").newInstance();
        System.out.println(o.getClass());
        System.out.println(o instanceof CjqClassLoader);

    }
}
