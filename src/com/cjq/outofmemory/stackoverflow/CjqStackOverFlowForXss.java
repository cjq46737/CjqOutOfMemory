/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.outofmemory.stackoverflow
 * @className com.cjq.outofmemory.stackoverflow.CjqStackOverFlowForXss
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.outofmemory.stackoverflow;

/**
 * CjqStackOverFlowForXss
 * @description 通过设置Xss参数，抛出StackOverFLow
 * @author chenjunqi
 * @date 2022年03月28日 下午9:15
 * @version 3.0.0
 */
public class CjqStackOverFlowForXss {

    /**
     * 栈深度
     */
    private int stackLength = 1;

    /**
     * CjqStackOverFlowForXss
     * @description 栈泄漏方法，方法调用方法本身
     * @author chenjunqi
     * @date 2022/3/28 下午9:16
     * @version 3.0.0
     */
    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        CjqStackOverFlowForXss cjqStackOverFlowForXss = new CjqStackOverFlowForXss();
        try{
            cjqStackOverFlowForXss.stackLeak();
        }catch (Throwable e){
            System.out.println("stackLength:" + cjqStackOverFlowForXss.stackLength);
            throw e;
        }
    }
}
