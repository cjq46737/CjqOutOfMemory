/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.compile.sugar.autopack
 * @className com.cjq.jvm.compile.sugar.autopack.TestAutoPack
 * @copyright Copyright 2023 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.compile.sugar.autopack;

import java.util.Arrays;
import java.util.List;

/**
 * TestAutoPack
 * @description 自动装箱、拆箱、遍历循环
 * @author chenjunqi
 * @date 2023年08月16日 下午4:27
 * @version 3.0.0
 */
public class TestAutoPack {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3);
        int sum = 0;
        for (int i : list) {
            sum += i;
        }
        System.out.println(sum);

        f();
    }

    public static void f() {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        System.out.println(g == (a + b));
        System.out.println(g.equals(a + b));
    }
}
