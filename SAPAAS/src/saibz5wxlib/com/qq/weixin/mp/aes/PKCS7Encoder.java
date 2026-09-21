/*
 * Decompiled with CFR 0.152.
 */
package com.qq.weixin.mp.aes;

import java.nio.charset.Charset;
import java.util.Arrays;

class PKCS7Encoder {
    static Charset CHARSET = Charset.forName("utf-8");
    static int BLOCK_SIZE = 32;

    PKCS7Encoder() {
    }

    static byte[] encode(int count) {
        int amountToPad = BLOCK_SIZE - count % BLOCK_SIZE;
        if (amountToPad == 0) {
            amountToPad = BLOCK_SIZE;
        }
        char padChr = PKCS7Encoder.chr(amountToPad);
        String tmp = new String();
        int index = 0;
        while (index < amountToPad) {
            tmp = String.valueOf(tmp) + padChr;
            ++index;
        }
        return tmp.getBytes(CHARSET);
    }

    static byte[] decode(byte[] decrypted) {
        byte pad = decrypted[decrypted.length - 1];
        if (pad < 1 || pad > 32) {
            pad = 0;
        }
        return Arrays.copyOfRange(decrypted, 0, decrypted.length - pad);
    }

    static char chr(int a) {
        byte target = (byte)(a & 0xFF);
        return (char)target;
    }
}

