/*
 * Decompiled with CFR 0.152.
 */
package SA.SRFramework.Data;

import SA.SRFramework.Data.RefObject;
import SA.SRFramework.Utility.DateParser;
import java.util.Date;
import java.util.Hashtable;

public class ValueFunctions {
    public static String Call(String strDefaultValue) {
        if (strDefaultValue.indexOf("@@") != 0) {
            return strDefaultValue;
        }
        if (strDefaultValue.compareToIgnoreCase("@@DATETIME") == 0) {
            return DateParser.toDateTimeString(new Date());
        }
        if (strDefaultValue.compareToIgnoreCase("@@DATE") == 0) {
            return DateParser.toDateString(new Date());
        }
        if (strDefaultValue.compareToIgnoreCase("@@TIME") == 0) {
            return DateParser.toTimeString(new Date());
        }
        return strDefaultValue;
    }

    public static boolean GetParam(String strKey, Hashtable paramList, RefObject objValue) {
        if (strKey.indexOf("%%") != 0) {
            return false;
        }
        strKey = strKey.substring(2);
        if (paramList.containsKey(strKey = strKey.toUpperCase())) {
            objValue.setObject(paramList.get(strKey));
        } else {
            objValue.setObject(null);
        }
        return true;
    }
}

