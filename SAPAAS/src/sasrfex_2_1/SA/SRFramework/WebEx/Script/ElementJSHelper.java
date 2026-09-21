/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Script;

import SA.SRFramework.Utility.StringHelper;

public class ElementJSHelper {
    public static String getOnEventScript(String strElementId, String strEventName, int nEventParamCount, String strEventCode) {
        String strFuncParam = "";
        int i = 0;
        while (i < nEventParamCount) {
            if (StringHelper.Length((String)strFuncParam) != 0) {
                strFuncParam = String.valueOf(strFuncParam) + ",";
            }
            strFuncParam = String.valueOf(strFuncParam) + StringHelper.Format((String)"_%1$s", (Object)(i + 1));
            ++i;
        }
        String strOutput = "";
        strOutput = StringHelper.Format((String)"Ext.get('%1$s').on('%2$s',function(%3$s){%4$s});", (Object)strElementId, (Object)strEventName, (Object)strFuncParam, (Object)strEventCode);
        return strOutput;
    }
}

