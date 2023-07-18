/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.classloader.practice
 * @className com.cjq.jvm.classloader.practice.DynamicProxyTest
 * @copyright Copyright 2023 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.classloader.practice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * DynamicProxyTest
 * @description 动态代理测试
 * @author chenjunqi
 * @date 2023年07月17日 下午4:31
 * @version 3.0.0
 */
public class DynamicProxyTest {

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        IHello bind = (IHello) new DynamicProxy().bind(new Hello());
        bind.sayHello();
    }

    interface IHello {
        void sayHello();
    }

    static class Hello implements IHello {

        @Override
        public void sayHello() {
            System.out.println("cjq say hello...");
        }
    }

    static class DynamicProxy implements InvocationHandler {

        private Object sourceObject;

        public Object bind(Object sourceObject) {
            this.sourceObject = sourceObject;
            return Proxy.newProxyInstance(sourceObject.getClass().getClassLoader(), sourceObject.getClass().getInterfaces(), this);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("cjq is cool");
            return method.invoke(sourceObject, args);
        }
    }
}
