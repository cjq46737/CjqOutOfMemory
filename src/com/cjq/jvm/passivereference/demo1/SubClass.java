/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.passivereference.demo1
 * @className com.cjq.jvm.passivereference.demo1.SubClass
 * @copyright Copyright 2023 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.passivereference.demo1;

/**
 * SubClass
 * @description 被动引用-子类
 * @author chenjunqi
 * @date 2023年03月23日 下午7:57
 * @version 3.0.0
 */
public class SubClass extends SuperClass {
    static {
        System.out.println("subclass init....");
    }

}
