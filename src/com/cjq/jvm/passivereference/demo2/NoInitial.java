/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.passivereference.demo2
 * @className com.cjq.jvm.passivereference.demo2.NoInitlaztion
 * @copyright Copyright 2023 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.passivereference.demo2;

import com.cjq.jvm.passivereference.demo1.SuperClass;

/**
 * NoInitlaztion
 * @description 被动引用-没有初始化
 * @author chenjunqi
 * @date 2023年03月23日 下午8:23
 * @version 3.0.0
 */
public class NoInitial {

    public static void main(String[] args) {
        SuperClass[] superClasses = new SuperClass[2];
    }
}
