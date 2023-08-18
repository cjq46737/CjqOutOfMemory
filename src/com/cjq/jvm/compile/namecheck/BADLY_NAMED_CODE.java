/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.compile.namecheck
 * @className com.cjq.jvm.compile.namecheck.BADLY_CODE_NAME
 * @copyright Copyright 2023 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.compile.namecheck;

/**
 * BADLY_CODE_NAME
 * @description 命名错误的测试代码
 * @author chenjunqi
 * @date 2023年08月18日 下午3:15
 * @version 3.0.0
 */
public class BADLY_NAMED_CODE {

    static final int _FORTY_TWO = 42;

    public static int NOT_A_CONSTANT = _FORTY_TWO;

    protected void BADLY_NAMED_CODE() {
        return;
    }

    public void NOTcamelCASEmethodNAME() {
        return;
    }

    enum colors {
        red, yello, green, blue
    }
}
