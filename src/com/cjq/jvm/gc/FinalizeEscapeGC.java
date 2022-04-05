/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.gc
 * @className com.cjq.jvm.gc.FinalizeEscapeGC
 * @copyright Copyright 2022 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.gc;

/**
 * FinalizeEscapeGC
 * @description 测试对象通过finalize方法逃脱GC，但是只能逃脱一次，因为finalize方法只会被系统自动调用一次
 * @author chenjunqi
 * @date 2022年04月05日 上午9:53
 * @version 3.0.0
 */
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVE_HOOK = null;

    public static void main(String[] args) throws Exception {
        SAVE_HOOK = new FinalizeEscapeGC();
        SAVE_HOOK = null;
        System.gc();
        // finalizer方法优先级很低，暂停0.5s等待它
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no,i am dead");
        }

        // 第二次自救失败，因为finalize方法只会被系统自动执行一次
        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no,i am dead");
        }

    }

    public void isAlive() {
        System.out.println("yes,i am still alive");
    }

    @Override
    public void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed");
        SAVE_HOOK = this;
    }
}
