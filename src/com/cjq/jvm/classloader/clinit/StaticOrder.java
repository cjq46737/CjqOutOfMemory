/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.classloader.clinit
 * @className com.cjq.jvm.classloader.clinit.StaticOrder
 * @copyright Copyright 2023 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.classloader.clinit;

/**
 * StaticOrder
 * @description 静态变量，不能访问后面的静态变量，只能赋值，save actions自动调整顺序
 * @author chenjunqi
 * @date 2023年04月08日 下午1:56
 * @version 3.0.0
 */
public class StaticOrder {

    public static int a;

    static {
        // 可以赋值
        a = 0;
        // 不能访问，编译报错
        System.out.println(a);
    }
}
