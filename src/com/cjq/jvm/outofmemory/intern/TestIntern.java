/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.outofmemory.intern
 * @className com.cjq.outofmemory.intern.TestIntern
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.outofmemory.intern;

/**
 * TestIntern
 * @description java8测试String的intern方法，和java6比较
 * @author chenjunqi
 * @date 2022年03月30日 下午8:39
 * @version 3.0.0
 */
public class TestIntern {

    /**
     * TestIntern
     * @description 返回值为false、true，
     * java8的字符串常量池移到了堆中，所以只需要记录常量第一次出现的引用
     * 计算机科学是第一次进入常量池，所以true
     * java这个常量在sun.mics.Version加载时进入常量池，所以s2进入常量池操作时候，返回的第一次进入常量池的引用，所以为false
     * @param args args
     * @author chenjunqi
     * @date 2022/3/30 下午8:42
     * @version 3.0.0
     */
    public static void main(String[] args) {
        String s1 = new StringBuilder("计算机").append("科学").toString();
        System.out.println(s1 == s1.intern());

        String s2 = new StringBuilder("ja").append("va").toString();
        System.out.println(s2 == s2.intern());
    }
}
