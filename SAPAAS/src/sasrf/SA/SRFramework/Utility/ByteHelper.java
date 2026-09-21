/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Utility;

public class ByteHelper {
    public static void MemCpy(byte[] destlist, int nDestStartPos, byte[] srcList, int nSrcStartPos, int nCopyLength) {
        int nPos = 0;
        int i = nSrcStartPos;
        while (i < nSrcStartPos + nCopyLength) {
            destlist[nDestStartPos + nPos] = srcList[i];
            ++nPos;
            ++i;
        }
    }

    public static void MemSet(byte[] list, byte value) {
        ByteHelper.MemSet(list, 0, list.length, value);
    }

    public static void MemSet(byte[] list, int nLength, byte value) {
        ByteHelper.MemSet(list, 0, nLength, value);
    }

    public static void MemSet(byte[] list, int nStartPos, int nLength, byte value) {
        int i = nStartPos;
        while (i < nStartPos + nLength) {
            list[i] = value;
            ++i;
        }
    }

    public static int ToInt(byte[] list) {
        int nValue = 0;
        int i = 0;
        while (i < list.length) {
            int nByte = 1;
            int j = 0;
            while (j < 8) {
                if ((list[i] & nByte) > 0) {
                    nValue |= nByte;
                }
                nByte <<= 1;
                ++j;
            }
            if (i != list.length - 1) {
                nValue <<= 8;
            }
            ++i;
        }
        return nValue;
    }

    public static byte[] To2Byte(int value) {
        return ByteHelper.ToXByte(value, 2);
    }

    public static byte[] ToXByte(int value, int nSize) {
        byte[] list = new byte[nSize];
        int i = 0;
        while (i < nSize) {
            list[i] = 0;
            ++i;
        }
        i = nSize - 1;
        while (i >= 0) {
            int nByte = 1;
            int j = 0;
            while (j < 8) {
                if ((value & nByte) > 0) {
                    int n = i;
                    list[n] = (byte)(list[n] | nByte);
                }
                nByte <<= 1;
                ++j;
            }
            value >>= 8;
            --i;
        }
        return list;
    }
}

