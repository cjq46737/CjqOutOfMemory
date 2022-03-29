/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.outofmemory.heapoutofmemory
 * @className com.cjq.outofmemory.heapoutofmemory.CjqHeapOutOfMemory
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.outofmemory.heapoutofmemory;

import java.util.ArrayList;
import java.util.List;

/**
 * CjqHeapOutOfMemory
 * @description 堆内存oom
 * @author chenjunqi
 * @date 2022年03月28日 下午8:23
 * @version 3.0.0
 */
public class CjqHeapOutOfMemory {
    /**
     * CjqHeapOutOfMemory
     * @description 静态内部类用来，oom的对象
     * @author chenjunqi
     * @date 2022/3/28 下午8:24
     * @version 3.0.0
     */
    static class Cjq{}

    /**
     * CjqHeapOutOfMemory
     * @description -Xms20M -Xmx20M -XX:+HeapDumpOnOutOfMemoryError
     * @author chenjunqi
     * @date 2022/3/28 下午8:40
     * @version 3.0.0
     */
    public static void main(String[] args) {

        List<Cjq> list = new ArrayList<>();
        while(true){
            list.add(new Cjq());
        }
    }

}
