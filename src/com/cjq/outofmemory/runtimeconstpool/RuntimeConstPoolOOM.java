/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.outofmemory.runtimeconstpool
 * @className com.cjq.outofmemory.runtimeconstpool.RuntimeConstPoolOOM
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.outofmemory.runtimeconstpool;

import java.util.HashSet;
import java.util.Set;

/**
 * RuntimeConstPoolOOM
 * @description -Xmx导致运行时常量池OOM
 * @author chenjunqi
 * @date 2022年03月30日 下午8:16
 * @version 3.0.0
 */
public class RuntimeConstPoolOOM {

    /**
     * RuntimeConstPoolOOM
     * @description -Xmx6M：map扩容OOM；-Xmx3M：String字符串OOM
     * @param args args
     * @author chenjunqi
     * @date 2022/3/30 下午8:25
     * @version 3.0.0
     */
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        int i = 0;
        while(true){
            set.add(String.valueOf(i++).intern());
        }
    }
}
