/*
 * Decompiled with CFR 0.152.
 */
package com.qq.weixin.mp.aes;

import com.qq.weixin.mp.aes.AesException;
import java.security.MessageDigest;
import java.util.Arrays;

class SHA1 {
    SHA1() {
    }

    public static String getSHA1(String token, String timestamp, String nonce, String encrypt) throws AesException {
        try {
            Object[] array = new String[]{token, timestamp, nonce, encrypt};
            StringBuffer sb = new StringBuffer();
            Arrays.sort(array);
            int i = 0;
            while (i < 4) {
                sb.append((String)array[i]);
                ++i;
            }
            String str = sb.toString();
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(str.getBytes());
            byte[] digest = md.digest();
            StringBuffer hexstr = new StringBuffer();
            String shaHex = "";
            int i2 = 0;
            while (i2 < digest.length) {
                shaHex = Integer.toHexString(digest[i2] & 0xFF);
                if (shaHex.length() < 2) {
                    hexstr.append(0);
                }
                hexstr.append(shaHex);
                ++i2;
            }
            return hexstr.toString();
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new AesException(-40003);
        }
    }
}

