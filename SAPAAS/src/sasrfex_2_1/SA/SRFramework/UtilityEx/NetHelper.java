/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.UtilityEx;

public class NetHelper {
    public static long BitToNetmask(int size) {
        long nValue = 0L;
        int i = 0;
        while (i < 32) {
            nValue = i < size ? (nValue << 1) + 1L : (nValue << 1) + 0L;
            ++i;
        }
        return nValue;
    }

    public static String LongToIP(long longIp) {
        StringBuffer sb = new StringBuffer("");
        sb.append(String.valueOf(longIp >>> 24));
        sb.append(".");
        sb.append(String.valueOf((longIp & 0xFFFFFFL) >>> 16));
        sb.append(".");
        sb.append(String.valueOf((longIp & 0xFFFFL) >>> 8));
        sb.append(".");
        sb.append(String.valueOf(longIp & 0xFFL));
        return sb.toString();
    }

    public static long IpToLong(String strIp) {
        long[] ip = new long[4];
        int position1 = strIp.indexOf(".");
        int position2 = strIp.indexOf(".", position1 + 1);
        int position3 = strIp.indexOf(".", position2 + 1);
        ip[0] = Long.parseLong(strIp.substring(0, position1));
        ip[1] = Long.parseLong(strIp.substring(position1 + 1, position2));
        ip[2] = Long.parseLong(strIp.substring(position2 + 1, position3));
        ip[3] = Long.parseLong(strIp.substring(position3 + 1));
        return (ip[0] << 24) + (ip[1] << 16) + (ip[2] << 8) + ip[3];
    }
}

