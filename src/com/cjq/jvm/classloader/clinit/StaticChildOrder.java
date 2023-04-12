/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.classloader.clinit
 * @className com.cjq.jvm.classloader.clinit.StaticChildOrder
 * @copyright Copyright 2023 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.classloader.clinit;

/**
 * StaticChildOrder
 * @description 父类<clinit>()方法先执行，子类
 * @author chenjunqi
 * @date 2023年04月08日 下午2:08
 * @version 3.0.0
 */
public class StaticChildOrder extends StaticParentOrder {

    public static int B = A;

    public static void main(String[] args) {
        System.out.println(StaticChildOrder.B);
    }
}
