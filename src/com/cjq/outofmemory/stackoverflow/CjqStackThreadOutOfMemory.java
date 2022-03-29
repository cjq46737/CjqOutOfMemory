/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.outofmemory.stackoverflow
 * @className com.cjq.outofmemory.stackoverflow.CjqStackThreadOutOfMemory
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.outofmemory.stackoverflow;

/**
 * CjqStackThreadOutOfMemory
 * @description 不断创建新线程，因为不能为线程申请内存时，导致的OOM
 * @author chenjunqi
 * @date 2022年03月29日 下午8:06
 * @version 3.0.0
 */
public class CjqStackThreadOutOfMemory {

    private void dontStop(){
        while (true){}
    }

    public void stackLeakByThread(){
        while(true){
            Thread thread = new Thread(this::dontStop);
            thread.start();
        }
    }

    public static void main(String[] args) {
        CjqStackThreadOutOfMemory cjqStackThreadOutOfMemory = new CjqStackThreadOutOfMemory();
        cjqStackThreadOutOfMemory.stackLeakByThread();
    }
}
