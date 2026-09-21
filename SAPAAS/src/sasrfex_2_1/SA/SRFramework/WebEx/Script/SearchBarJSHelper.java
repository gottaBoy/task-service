/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Script;

import SA.SRFramework.Utility.StringHelper;

public class SearchBarJSHelper {
    public static String getLoadConditionScript(String strSearchBarId) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"$P.searchbar['%1$s'].loadcondition();", (Object)strSearchBarId);
        return strOutput;
    }
}

