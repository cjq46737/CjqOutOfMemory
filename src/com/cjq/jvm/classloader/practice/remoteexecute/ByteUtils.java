/*
 * @projectName CjqOutOfMemory
 * @package com.cjq.jvm.classloader.practice.remoteexecute
 * @className com.cjq.jvm.classloader.practice.remoteexecute.ByteUtils
 * @copyright Copyright 2023 Thuisoft, Inc. All rights reserved.
 */
package com.cjq.jvm.classloader.practice.remoteexecute;

/**
 * ByteUtils
 * @description 数组处理工具
 * @author chenjunqi
 * @date 2023年07月21日 上午10:27
 * @version 3.0.0
 */
public class ByteUtils {

    /**
     * ByteUtils
     * @description 字节数组转为int，核心就是：16进制字节转为10进制
     * @param bytes 整个class文件
     * @param start 从class文件 开始计算下标
     * @param len 多长的字节
     * @return 10进制结果
     * @author chenjunqi
     * @date 2023/7/21 下午3:22
     * @version 3.0.0
     */
    public static int bytes2Int(byte[] bytes, int start, int len) {
        int sum = 0;
        int end = start + len;
        for (int i = start; i < end; i++) {
            int n = ((int) bytes[i]) & 0xff;
            n <<= (--len) * 8;
            sum += n;
        }
        return sum;
    }

    /**
     * ByteUtils
     * @description int转byte数组，核心就是10进制转为16进制字节数组
     * @param value int
     * @param len byte数组长度
     * @return byte[]
     * @author chenjunqi
     * @date 2023/7/21 下午3:24
     * @version 3.0.0
     */
    public static byte[] int2Bytes(int value, int len) {
        byte[] result = new byte[len];
        for (int i = 0; i < len; i++) {
            result[len - i - 1] = (byte) ((value >> 8 * i) & 0xff);
        }
        return result;
    }

    /**
     * ByteUtils
     * @description 字节数组转字符串
     * @param bytes bytes
     * @param start start
     * @param len len
     * @return String
     * @author chenjunqi
     * @date 2023/7/21 下午3:25
     * @version 3.0.0
     */
    public static String bytes2String(byte[] bytes, int start, int len) {
        return new String(bytes, start, len);
    }

    /**
     * ByteUtils
     * @description 字符串转为字节数组
     * @param value 字符串
     * @return 字节数组
     * @author chenjunqi
     * @date 2023/7/21 下午3:26
     * @version 3.0.0
     */
    public static byte[] string2Bytes(String value) {
        return value.getBytes();
    }

    /**
     * ByteUtils
     * @description 字节数组替换
     * @param originalBytes 原始数组
     * @param offset 开始下标
     * @param len 长度
     * @param replaceBytes 替换数组
     * @return byte[]
     * @author chenjunqi
     * @date 2023/7/21 下午3:25
     * @version 3.0.0
     */
    public static byte[] bytesReplace(byte[] originalBytes, int offset, int len, byte[] replaceBytes) {
        byte[] result = new byte[originalBytes.length + (replaceBytes.length - len)];
        System.arraycopy(originalBytes, 0, result, 0, offset);
        System.arraycopy(replaceBytes, 0, result, offset, replaceBytes.length);
        System.arraycopy(originalBytes, offset + len, result, offset + replaceBytes.length, originalBytes.length - offset - len);
        return result;
    }
}
