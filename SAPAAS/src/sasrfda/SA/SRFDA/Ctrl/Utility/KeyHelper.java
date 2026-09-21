/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.Helper
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Ctrl.Utility;

import SA.SRFramework.Utility.Helper;
import SA.SRFramework.Utility.StringHelper;

public class KeyHelper {
    public static String GetTempKey() {
        return KeyHelper.GetTempKey("");
    }

    public static String GetTempKey(String strKey) {
        String strFullKey = "SRFDATEMPKEYID:";
        if (StringHelper.IsNullOrEmpty((String)strKey)) {
            return String.valueOf(strFullKey) + Helper.GenGuid();
        }
        return String.valueOf(strFullKey) + strKey;
    }

    public static boolean IsTempKey(String strKey) {
        return strKey.indexOf("SRFDATEMPKEYID:") == 0;
    }
}

