/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.classloader.validate
 * @className com.cjq.jvm.classloader.validate.Child
 * @copyright Copyright 2023 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.classloader.validate;

/**
 * Child
 * @description 父类和接口出现了统一字段名-子类
 * @author chenjunqi
 * @date 2023年04月05日 上午9:45
 * @version 3.0.0
 */
public class Child extends Parent implements Interface {

    //    public static int a = 44;

    public static void main(String[] args) {
        System.out.println(Child.a);
    }
}
