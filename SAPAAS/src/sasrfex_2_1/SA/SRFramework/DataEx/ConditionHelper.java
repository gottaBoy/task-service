/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Data.DataTypeHelper
 */
package SA.SRFramework.DataEx;

import SA.SRFramework.Data.DataTypeHelper;
import SA.SRFramework.DataEx.Conditions;
import java.util.Vector;

public class ConditionHelper {
    private static Vector<String> conditions = new Vector();

    static {
        conditions.add("=");
        conditions.add("==");
        conditions.add(">");
        conditions.add(">=");
        conditions.add("<");
        conditions.add("<=");
        conditions.add("<>");
        conditions.add("ISNULL");
        conditions.add("ISNOTNULL");
        conditions.add("LIKE");
        conditions.add("LEFTLIKE");
        conditions.add("RIGHTLIKE");
        conditions.add("IN");
        conditions.add("NOTIN");
    }

    public static boolean IsSupportDataType(String strDataType, String strSearchAction) {
        int nDataType = DataTypeHelper.FromString((String)strDataType);
        return ConditionHelper.IsSupportDataType(nDataType, strSearchAction);
    }

    public static boolean IsSupportDataType(int nDataType, String strSearchAction) {
        int nCondition = Conditions.FromString(strSearchAction);
        if (nCondition == 0) {
            return false;
        }
        switch (nDataType) {
            case 0: {
                return false;
            }
            case 2: 
            case 8: 
            case 19: 
            case 20: 
            case 21: 
            case 24: 
            case 26: {
                return nCondition == 7 || nCondition == 8 || nCondition == 15;
            }
            case 4: 
            case 11: 
            case 12: 
            case 13: 
            case 25: {
                return nCondition == 6 || nCondition == 7 || nCondition == 8 || nCondition == 15 || nCondition == 1 || nCondition == 12 || nCondition == 9 || nCondition == 16 || nCondition == 17 || nCondition == 13 || nCondition == 14;
            }
            case 1: 
            case 3: 
            case 6: 
            case 7: 
            case 9: 
            case 10: 
            case 14: 
            case 15: 
            case 17: 
            case 18: 
            case 23: {
                return nCondition == 8 || nCondition == 7 || nCondition == 15 || nCondition == 1 || nCondition == 12 || nCondition == 2 || nCondition == 3 || nCondition == 4 || nCondition == 5 || nCondition == 6 || nCondition == 13 || nCondition == 14;
            }
            case 5: 
            case 16: 
            case 22: 
            case 27: 
            case 28: {
                return nCondition == 8 || nCondition == 7 || nCondition == 15 || nCondition == 1 || nCondition == 12 || nCondition == 2 || nCondition == 3 || nCondition == 4 || nCondition == 5 || nCondition == 6;
            }
        }
        return false;
    }

    public static Vector<String> GetDataTypeSupportConditions(String strDataType) {
        Vector<String> arrs = new Vector<String>();
        for (String strCondition : conditions) {
            int nDataType = DataTypeHelper.FromString((String)strDataType);
            if (!ConditionHelper.IsSupportDataType(nDataType, strCondition)) continue;
            arrs.add(strCondition);
        }
        return arrs;
    }
}

