/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.compile.sugar
 * @className com.cjq.jvm.compile.sugar.generic.TestSugar
 * @copyright Copyright 2023 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.compile.sugar.generic;

import java.util.HashMap;
import java.util.Map;

/**
 * TestSugar
 * @description java泛型编译时编译成裸类型，使用时强制类型转换
 * @author chenjunqi
 * @date 2023年08月15日 下午2:40
 * @version 3.0.0
 */
public class TestGeneric2 {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("cjq", "cool");
        System.out.println(map.get("cjq"));

    }

}
