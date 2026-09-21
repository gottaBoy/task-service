/*
 * Decompiled with CFR 0.152.
 */
package net.ibizsys.paas.util;

import java.rmi.server.UID;
import java.security.MessageDigest;
import java.util.Date;
import java.util.UUID;
import net.ibizsys.paas.util.StringHelper;

public final class KeyValueHelper {
    private static Integer nGlobalId = 0;

    public static final String genGuid() {
        UID uid = new UID();
        String strId = "uid_" + uid.toString();
        strId = strId.replace(":", "");
        strId = strId.replace("-", "");
        return strId;
    }

    public static final String genGuidEx() {
        UUID idOne = UUID.randomUUID();
        return idOne.toString().toUpperCase();
    }

    private static final String convertToHex(byte[] data) {
        StringBuffer buf = new StringBuffer();
        int i = 0;
        while (i < data.length) {
            int halfbyte = data[i] >>> 4 & 0xF;
            int two_halfs = 0;
            do {
                if (halfbyte >= 0 && halfbyte <= 9) {
                    buf.append((char)(48 + halfbyte));
                } else {
                    buf.append((char)(97 + (halfbyte - 10)));
                }
                halfbyte = data[i] & 0xF;
            } while (two_halfs++ < 1);
            ++i;
        }
        return buf.toString();
    }

    public static final String genMD5(String text) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] md5hash = new byte[32];
            md.update(text.getBytes("iso-8859-1"), 0, text.length());
            md5hash = md.digest();
            return KeyValueHelper.convertToHex(md5hash);
        }
        catch (Exception ex) {
            return "";
        }
    }

    public static final String genMD5Ex(String text) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] md5hash = new byte[32];
            md.update(text.getBytes("utf-8"));
            md5hash = md.digest();
            return KeyValueHelper.convertToHex(md5hash);
        }
        catch (Exception ex) {
            return "";
        }
    }

    public static final long curTime() {
        return new Date().getTime();
    }

    public static final String genUniqueId(String strSrc1) {
        return KeyValueHelper.genMD5Ex(strSrc1);
    }

    public static final String genUniqueId(String strSrc1, String strSrc2) {
        return KeyValueHelper.genMD5Ex(StringHelper.format("%1$s||%2$s", strSrc1, strSrc2));
    }

    public static final String genUniqueId(String strSrc1, String strSrc2, String strSrc3) {
        return KeyValueHelper.genMD5Ex(StringHelper.format("%1$s||%2$s||%3$s", strSrc1, strSrc2, strSrc3));
    }

    public static final String genUniqueId(String strSrc1, String strSrc2, String strSrc3, String strSrc4) {
        return KeyValueHelper.genMD5Ex(StringHelper.format("%1$s||%2$s||%3$s||%4$s", strSrc1, strSrc2, strSrc3, strSrc4));
    }

    public static final String genUniqueId(String strSrc1, String strSrc2, String strSrc3, String strSrc4, String strSrc5) {
        return KeyValueHelper.genMD5Ex(StringHelper.format("%1$s||%2$s||%3$s||%4$s||%5$s", strSrc1, strSrc2, strSrc3, strSrc4, strSrc5));
    }

    public static final String genUniqueId(String strSrc1, String strSrc2, String strSrc3, String strSrc4, String strSrc5, String strSrc6) {
        return KeyValueHelper.genMD5Ex(StringHelper.format("%1$s||%2$s||%3$s||%4$s||%5$s||%6$s", strSrc1, strSrc2, strSrc3, strSrc4, strSrc5, strSrc6));
    }

    public static final boolean isTempKey(String strKeyValue) {
        return strKeyValue.indexOf("SRFTEMPKEY:") == 0;
    }
}

