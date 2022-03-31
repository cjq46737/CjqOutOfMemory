/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.outofmemory.methodarea
 * @className com.cjq.outofmemory.methodarea.CjqMethodAreaOOM
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.outofmemory.methodarea;



import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CjqMethodAreaOOM
 * @description 方法区oom，java8已经移出永久代，所以不会出现OutOfMemory Permgen Space
 * @author chenjunqi
 * @date 2022年03月30日 下午9:14
 * @version 3.0.0
 */
public class CjqMethodAreaOOM {

    public static void main(String[] args) {
        while(true){

            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(CjqCool.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invoke(o,objects);
                }
            });
            enhancer.create();
        }
    }

    static class CjqCool{}
}
