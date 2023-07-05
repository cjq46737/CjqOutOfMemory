/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.bytecodeengine.invoke
 * @className com.cjq.jvm.bytecodeengine.invoke.DynamicDispatchPractice
 * @copyright Copyright 2023 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.bytecodeengine.invoke;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;

/**
 * DynamicDispatchPractice
 * @description 分派实践
 * @author chenjunqi
 * @date 2023年06月26日 下午5:14
 * @version 3.0.0
 */
public class DispatchPractice {

    public static void main(String[] args) {
        Son son = new Son();
        son.thinking();

    }

    public static class GrandFather {
        public void thinking() {
            System.out.println("grandfather");
        }
    }

    public static class Father extends GrandFather {
        public void thinking() {
            System.out.println("father");
        }
    }

    public static class Son extends Father {
        public void thinking() {
            try {
                MethodType mt = MethodType.methodType(void.class);
                Field field = MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP");
                field.setAccessible(true);
                MethodHandle thinking = ((MethodHandles.Lookup) field.get(null))
                        .findSpecial(GrandFather.class, "thinking", mt, Father.class);
                thinking.invoke(this);
                //                        MethodHandle methodHandle = MethodHandles.lookup().findSpecial(GrandFather.class, "thinking", mt, getClass());
                //                methodHandle.invoke(this);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }
}
