/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.pswx.util;

import java.security.MessageDigest;

public final class SHA1Helper {
    private static final char[] HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static String getFormattedText(byte[] bytes) {
        int len = bytes.length;
        StringBuilder buf = new StringBuilder(len * 2);
        int j = 0;
        while (j < len) {
            buf.append(HEX_DIGITS[bytes[j] >> 4 & 0xF]);
            buf.append(HEX_DIGITS[bytes[j] & 0xF]);
            ++j;
        }
        return buf.toString();
    }

    public static String encode(String str) {
        if (str == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            messageDigest.update(str.getBytes());
            return SHA1Helper.getFormattedText(messageDigest.digest());
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

