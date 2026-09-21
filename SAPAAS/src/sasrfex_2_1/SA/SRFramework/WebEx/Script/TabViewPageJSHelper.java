/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Script;

import SA.SRFramework.Utility.StringHelper;

public class TabViewPageJSHelper {
    public static String getTabViewPageScript(String strTabViewId, String strTabViewPageId) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"$P.tabview['%1$s']._PAGES['%2$s']", (Object)strTabViewId, (Object)strTabViewPageId);
        return strOutput;
    }

    public static String getTabViewPageDataScript(String strTabViewId, String strTabViewPageId) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"$P.tabview['%1$s']._PAGES['%2$s'].getdata()", (Object)strTabViewId, (Object)strTabViewPageId);
        return strOutput;
    }

    public static String getOnDataChangedEventScript(String strTabViewId, String strTabViewPageId, String strEventCode) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"$P.tabview['%1$s']._PAGES['%2$s'].on('datachanged',function(_1){%3$s});", (Object)strTabViewId, (Object)strTabViewPageId, (Object)strEventCode);
        return strOutput;
    }

    public static String getOnDataReloadedEventScript(String strTabViewId, String strTabViewPageId, String strEventCode) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"$P.tabview['%1$s']._PAGES['%2$s'].on('datareloaded',function(_1){%3$s});", (Object)strTabViewId, (Object)strTabViewPageId, (Object)strEventCode);
        return strOutput;
    }

    public static String getOnListChangedEventScript(String strTabViewId, String strTabViewPageId, String strEventCode) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"$P.tabview['%1$s']._PAGES['%2$s'].on('listchanged',function(_1){%3$s});", (Object)strTabViewId, (Object)strTabViewPageId, (Object)strEventCode);
        return strOutput;
    }
}

