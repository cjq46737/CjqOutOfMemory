/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.bytecodeengine.invoke
 * @className com.cjq.jvm.bytecodeengine.invoke.TestInvokeDynamic
 * @copyright Copyright 2023 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.bytecodeengine.invoke;

import java.lang.invoke.*;

/**
 * TestInvokeDynamic
 * @description invokedynamic字节码指令
 * @author chenjunqi
 * @date 2023年06月25日 下午8:41
 * @version 3.0.0
 */
public class InvokeDynamicTest {

    public static void main(String[] args) throws Throwable {
        INDY_BootstrapMethod().invokeExact("icyfenix");
    }

    public static void testMethod(String s) {
        System.out.println("hello String:" + s);
    }

    public static CallSite BootstrapMethod(MethodHandles.Lookup lookup, String name, MethodType mt) throws Throwable {
        return new ConstantCallSite(lookup.findStatic(InvokeDynamicTest.class, name, mt));
    }

    private static MethodType MT_BootstrapMethod() {
        return MethodType.fromMethodDescriptorString(
                "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;",
                null);
    }

    private static MethodHandle MH_BootstrapMethod() throws Throwable {
        return MethodHandles.lookup().findStatic(InvokeDynamicTest.class, "BootstrapMethod", MT_BootstrapMethod());
    }

    private static MethodHandle INDY_BootstrapMethod() throws Throwable {
        CallSite cs = (CallSite) MH_BootstrapMethod().invokeWithArguments(MethodHandles.lookup(), "testMethod",
                MethodType.fromMethodDescriptorString("(Ljava/lang/String;)V", null));
        return cs.dynamicInvoker();
    }
}
