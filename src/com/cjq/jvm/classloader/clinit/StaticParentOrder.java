/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.classloader.clinit
 * @className com.cjq.jvm.classloader.clinit.StaticParentOrder
 * @copyright Copyright 2023 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.classloader.clinit;

/**
 * StaticParentOrder
 * @description 父类<clinit>()方法先执行，父类
 * @author chenjunqi
 * @date 2023年04月08日 下午2:07
 * @version 3.0.0
 */
public class StaticParentOrder {

    public static int A = 1;

    static {
        A = 2;
    }
}
