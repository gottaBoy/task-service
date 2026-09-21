/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Script;

import SA.SRFramework.Utility.StringHelper;

public class RemotePanelJSHelper {
    public static String getRemotePanel(String strRemotePanelId) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"$P.remotepanel['%1$s']", (Object)strRemotePanelId);
        return strOutput;
    }

    public static String getSetDefaultURL(String strRemotePanelId, String strURL) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"$P.remotepanel['%1$s'].setDefaultUrl(%2$s);", (Object)strRemotePanelId, (Object)strURL);
        return strOutput;
    }

    public static String getRefresh(String strRemotePanelId) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"$P.remotepanel['%1$s'].refresh();", (Object)strRemotePanelId);
        return strOutput;
    }
}

