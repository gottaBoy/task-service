/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Utility;

import SA.SRFramework.Utility.StringHelper;

public class NetHelper {
    public static boolean ParseIpAddr(String strIpAddr, int[] IpAddress) {
        block11: {
            block10: {
                block9: {
                    String[] list;
                    block8: {
                        if (StringHelper.Length(strIpAddr) == 0 || IpAddress == null) {
                            return false;
                        }
                        list = strIpAddr.split("[.]");
                        if (list.length == 4) break block8;
                        return false;
                    }
                    try {
                        int i = 0;
                        while (i < 4) {
                            IpAddress[i] = Integer.parseInt(list[i]);
                            ++i;
                        }
                        if (IpAddress[0] >= 0 && IpAddress[0] < 255) break block9;
                        return false;
                    }
                    catch (Exception ex) {
                        return false;
                    }
                }
                if (IpAddress[1] >= 0 && IpAddress[1] < 255) break block10;
                return false;
            }
            if (IpAddress[2] >= 0 && IpAddress[2] < 255) break block11;
            return false;
        }
        return IpAddress[3] >= 0 && IpAddress[3] < 255;
    }

    public static String ReformatMacAddr(String strMacAddr) {
        return NetHelper.ReformatMacAddr(strMacAddr, ":");
    }

    public static String ReformatMacAddr(String strMacAddr, String strSperator) {
        int[] MacAddress = new int[6];
        if (!NetHelper.ParseMacAddr(strMacAddr, MacAddress)) {
            return "";
        }
        return StringHelper.Format("%1$02X%7$s%2$02X%7$s%3$02X%7$s%4$02X%7$s%5$02X%7$s%6$02X", MacAddress[0], MacAddress[1], MacAddress[2], MacAddress[3], MacAddress[4], MacAddress[5], strSperator).toUpperCase();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean ParseMacAddr(String strMacAddr, int[] MacAddress) {
        if (StringHelper.Length(strMacAddr) == 0) {
            return false;
        }
        try {
            String[] list = strMacAddr.split("[.]");
            if (list.length != 6 && (list = strMacAddr.split("[:]")).length != 6 && (list = strMacAddr.split("[-]")).length != 6) {
                return false;
            }
            int i = 0;
            while (true) {
                if (i >= 6) {
                    if (MacAddress[0] >= 0 && MacAddress[0] <= 255) break;
                    return false;
                }
                int nValue = NetHelper.GetMacValue(list[i]);
                if (nValue == -1) {
                    return false;
                }
                MacAddress[i] = nValue;
                ++i;
            }
            if (MacAddress[1] < 0 || MacAddress[1] > 255) {
                return false;
            }
            if (MacAddress[2] < 0 || MacAddress[2] > 255) {
                return false;
            }
            if (MacAddress[3] < 0 || MacAddress[3] > 255) {
                return false;
            }
            if (MacAddress[4] < 0 || MacAddress[4] > 255) {
                return false;
            }
            return MacAddress[5] >= 0 && MacAddress[5] <= 255;
        }
        catch (Exception ex) {
            return false;
        }
    }

    private static int GetMacValue(String strValue) {
        strValue = strValue.toUpperCase();
        int nValue = 0;
        int nLen = strValue.length();
        int i = 0;
        while (i < nLen) {
            char ch = strValue.charAt(i);
            if (ch >= '0' && ch <= '9') {
                nValue = nValue * 16 + (ch - 48);
            } else if (ch >= 'A' && ch <= 'F') {
                nValue = nValue * 16 + 10 + (ch - 65);
            } else {
                return -1;
            }
            ++i;
        }
        return nValue;
    }
}

