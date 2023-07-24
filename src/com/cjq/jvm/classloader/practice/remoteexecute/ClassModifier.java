/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.classloader.practice.remoteexecute
 * @className com.cjq.jvm.classloader.practice.remoteexecute.ClassModifier
 * @copyright Copyright 2023 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.classloader.practice.remoteexecute;

/**
 * ClassModifier
 * @description 修改字节码
 * @author chenjunqi
 * @date 2023年07月21日 上午10:04
 * @version 3.0.0
 */
public class ClassModifier {

    // class文件中常量池起始偏移
    // ca fe ba be 00-JDK主板吧 32-JDK自版本
    private static final int CONSTANT_POOL_COUNT_INDEX = 8;

    // CONSTANT_Utf8_info常量的tag标志，标志为1代表是UTF-8编码的字符串
    private static final int CONSTANT_Utf8_info = 1;

    // 常量池中11种常量所占长度，CONSTANT_Utf8_info型常量除外，因为是变长
    private static final int[] CONSTANT_ITEM_LENGTH = { -1, -1, -1, 5, 5, 9, 9, 3, 3, 5, 5, 5, 5 };

    private static final int u1 = 1;

    private static final int u2 = 2;

    private byte[] classbyte;

    public ClassModifier(byte[] classbyte) {
        this.classbyte = classbyte;
    }

    /**
     * ClassModifier
     * @description 获取常量池数量
     * @return 返回常量池数量
     * @author chenjunqi
     * @date 2023/7/21 下午3:07
     * @version 3.0.0
     */
    public int getConstantPoolCount() {
        // 常量池从8个字节开始是常量池信息
        // 常量池入口的u2代表常量池计数值，转换为int即可
        return ByteUtils.bytes2Int(classbyte, CONSTANT_POOL_COUNT_INDEX, u2);
    }

    /**
     * ClassModifier
     * @description 修改字节码中Constant_UTF8_info常量内容
     * @param oldStr 原来字符串
     * @param newStr 修改后字符串
     * @return 修改结果字节数组
     * @author chenjunqi
     * @date 2023/7/21 下午4:28
     * @version 3.0.0
     */
    public byte[] modifyUTF8Constant(String oldStr, String newStr) {
        // 常量池总计数
        int cpc = getConstantPoolCount();
        // 常量池偏移下标+2个字节用来存储常量池类型个数
        int offset = CONSTANT_POOL_COUNT_INDEX + u2;
        for (int i = 0; i < cpc; i++) {
            //CONSTANT_UTF8_info：
            //tag：标志位是1
            //length：UTF8编码的字符串占用的字符数，用2个字节存储
            //bytes：长度是length的UTF8的编码的字符串
            int tag = ByteUtils.bytes2Int(classbyte, offset, u1);
            if (tag == CONSTANT_Utf8_info) {
                int len = ByteUtils.bytes2Int(classbyte, offset + u1, u2);
                offset += (u1 + u2);
                String str = ByteUtils.bytes2String(classbyte, offset, len);
                if (str.equals(oldStr)) {
                    byte[] strBytes = ByteUtils.string2Bytes(newStr);
                    byte[] strLen = ByteUtils.int2Bytes(newStr.length(), u2);
                    classbyte = ByteUtils.bytesReplace(classbyte, offset - u2, u2, strLen);
                    classbyte = ByteUtils.bytesReplace(classbyte, offset, len, strBytes);
                    return classbyte;
                } else {
                    offset += len;
                }

            } else {
                offset += CONSTANT_ITEM_LENGTH[tag];
            }
        }
        return classbyte;
    }
}
