/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.compile.sugar.generic
 * @className com.cjq.jvm.compile.sugar.generic.T饿三天G恩Eric
 * @copyright Copyright 2023 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.compile.sugar.generic;

import java.util.ArrayList;

/**
 * T饿三天G恩Eric
 * @description 测试泛型，裸类型是泛型化类型的父类
 * @author chenjunqi
 * @date 2023年08月15日 下午4:33
 * @version 3.0.0
 */
public class TestGeneric1 {

    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        ArrayList list;
        list = list1;
        list = list2;

    }
}
