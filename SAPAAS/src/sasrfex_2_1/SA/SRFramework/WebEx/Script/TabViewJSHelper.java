/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Script;

import SA.SRFramework.Utility.StringHelper;

public class TabViewJSHelper {
    public static String getSetDataScript(String strTabViewId, String strData) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"$P.tabview['%1$s'].setdata(%2$s);", (Object)strTabViewId, (Object)strData);
        return strOutput;
    }

    public static String getSetDataExScript(String strTabViewId, String strData) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"$P.tabview['%1$s'].setdataex(%2$s);", (Object)strTabViewId, (Object)strData);
        return strOutput;
    }

    public static String getShowTabPageScript(String strTabViewId, String strTabPageId) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"$P.tabview['%1$s'].showpage('%2$s');", (Object)strTabViewId, (Object)strTabPageId);
        return strOutput;
    }

    public static String getShowTabPageScript2(String strTabViewId, String strTabPageId) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"$P.tabview['%1$s'].showpage(%2$s);", (Object)strTabViewId, (Object)strTabPageId);
        return strOutput;
    }

    public static String getSetTabPageVisibleScript(String strTabViewId, String strTabPageId, boolean bVisible) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"$P.tabview['%1$s'].setpagevisible('%2$s',%3$s);", (Object)strTabViewId, (Object)strTabPageId, (Object)(bVisible ? "true" : "false"));
        return strOutput;
    }

    public static String getGetDataScript(String strTabViewId) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"$P.tabview['%1$s']._DATA", (Object)strTabViewId);
        return strOutput;
    }

    public static String getChangeListScript(String strTabViewId) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"$P.tabview['%1$s'].changelist();", (Object)strTabViewId);
        return strOutput;
    }

    public static String getOnDataChangedEventScript(String strTabViewId, String strEventCode) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"$P.tabview['%1$s'].on('datachanged',function(_1){%2$s});", (Object)strTabViewId, (Object)strEventCode);
        return strOutput;
    }
}

