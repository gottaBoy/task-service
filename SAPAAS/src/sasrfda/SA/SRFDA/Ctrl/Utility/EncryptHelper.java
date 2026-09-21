/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFDA.Ctrl.Utility;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class EncryptHelper {
    private static final char[] CA = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static final int[] IA = new int[256];

    static {
        Arrays.fill(IA, -1);
        int i = 0;
        int iS = CA.length;
        while (i < iS) {
            EncryptHelper.IA[EncryptHelper.CA[i]] = i;
            ++i;
        }
        EncryptHelper.IA[61] = 0;
    }

    private static final char[] encodeToChar(byte[] sArr, boolean lineSep) {
        int sLen;
        int n = sLen = sArr != null ? sArr.length : 0;
        if (sLen == 0) {
            return new char[0];
        }
        int eLen = sLen / 3 * 3;
        int cCnt = (sLen - 1) / 3 + 1 << 2;
        int dLen = cCnt + (lineSep ? (cCnt - 1) / 76 << 1 : 0);
        char[] dArr = new char[dLen];
        int s = 0;
        int d = 0;
        int cc = 0;
        while (s < eLen) {
            int i = (sArr[s++] & 0xFF) << 16 | (sArr[s++] & 0xFF) << 8 | sArr[s++] & 0xFF;
            dArr[d++] = CA[i >>> 18 & 0x3F];
            dArr[d++] = CA[i >>> 12 & 0x3F];
            dArr[d++] = CA[i >>> 6 & 0x3F];
            dArr[d++] = CA[i & 0x3F];
            if (!lineSep || ++cc != 19 || d >= dLen - 2) continue;
            dArr[d++] = 13;
            dArr[d++] = 10;
            cc = 0;
        }
        int left = sLen - eLen;
        if (left > 0) {
            int i = (sArr[eLen] & 0xFF) << 10 | (left == 2 ? (sArr[sLen - 1] & 0xFF) << 2 : 0);
            dArr[dLen - 4] = CA[i >> 12];
            dArr[dLen - 3] = CA[i >>> 6 & 0x3F];
            dArr[dLen - 2] = left == 2 ? CA[i & 0x3F] : 61;
            dArr[dLen - 1] = 61;
        }
        return dArr;
    }

    private static final byte[] decodeFast(String s) {
        int sLen = s.length();
        if (sLen == 0) {
            return new byte[0];
        }
        int sIx = 0;
        int eIx = sLen - 1;
        while (sIx < eIx && IA[s.charAt(sIx) & 0xFF] < 0) {
            ++sIx;
        }
        while (eIx > 0 && IA[s.charAt(eIx) & 0xFF] < 0) {
            --eIx;
        }
        int pad = s.charAt(eIx) == '=' ? (s.charAt(eIx - 1) == '=' ? 2 : 1) : 0;
        int cCnt = eIx - sIx + 1;
        int sepCnt = sLen > 76 ? (s.charAt(76) == '\r' ? cCnt / 78 : 0) << 1 : 0;
        int len = ((cCnt - sepCnt) * 6 >> 3) - pad;
        byte[] dArr = new byte[len];
        int d = 0;
        int cc = 0;
        int eLen = len / 3 * 3;
        while (d < eLen) {
            int i = IA[s.charAt(sIx++)] << 18 | IA[s.charAt(sIx++)] << 12 | IA[s.charAt(sIx++)] << 6 | IA[s.charAt(sIx++)];
            dArr[d++] = (byte)(i >> 16);
            dArr[d++] = (byte)(i >> 8);
            dArr[d++] = (byte)i;
            if (sepCnt <= 0 || ++cc != 19) continue;
            sIx += 2;
            cc = 0;
        }
        if (d < len) {
            int i = 0;
            int j = 0;
            while (sIx <= eIx - pad) {
                i |= IA[s.charAt(sIx++)] << 18 - j * 6;
                ++j;
            }
            int r = 16;
            while (d < len) {
                dArr[d++] = (byte)(i >> r);
                r -= 8;
            }
        }
        return dArr;
    }

    public static final String decode(String s) throws UnsupportedEncodingException {
        return new String(EncryptHelper.decodeFast(s), "UTF-8");
    }

    public static final String encode(String s) {
        try {
            return new String(EncryptHelper.encodeToChar(s.getBytes("UTF-8"), false));
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static final String encodeCustomString(String s) {
        if (s == null || s.equals("")) {
            return s;
        }
        String s2 = "";
        int i = 0;
        while (i < s.length()) {
            String ch = String.valueOf(s.charAt(i));
            s2 = ch.getBytes().length == 1 ? String.valueOf(s2) + ch + "  " : String.valueOf(s2) + ch;
            ++i;
        }
        return s2;
    }

    private static final String decodeCustomString(String s) {
        if (s == null || s.equals("")) {
            return s;
        }
        String s2 = "";
        int nLen = s.length();
        int nIndex = 0;
        while (nIndex < nLen) {
            String ch = String.valueOf(s.charAt(nIndex));
            s2 = String.valueOf(s2) + ch;
            if (ch.getBytes().length == 1) {
                nIndex += 3;
                continue;
            }
            ++nIndex;
        }
        return s2;
    }

    public static final String encode2(String s) {
        try {
            if (s == null || s.equals("")) {
                return s;
            }
            String ns = EncryptHelper.encodeCustomString(s);
            return new String(EncryptHelper.encodeToChar(ns.getBytes("UTF-8"), false));
        }
        catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    public static final String decode2(String s) {
        try {
            if (s == null || s.equals("")) {
                return s;
            }
            String ds = new String(EncryptHelper.decodeFast(s), "UTF-8");
            return EncryptHelper.decodeCustomString(ds);
        }
        catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
}

