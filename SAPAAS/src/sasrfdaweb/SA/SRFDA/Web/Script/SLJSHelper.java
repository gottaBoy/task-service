/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 *  SA.SRFramework.Web.WebUtility
 */
package SA.SRFDA.Web.Script;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.Web.WebUtility;

public class SLJSHelper {
    public static final String DIALOGRESULT_OK = "OK";
    public static final String DIALOGRESULT_CANCEL = "CANCEL";
    public static final String DIALOGRESULT_NONE = "NONE";
    public static final String DIALOGRESULT_YES = "YES";
    public static final String DIALOGRESULT_NO = "NO";

    public static String getAlertMessageScript(String strMessage) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"alert('%1$s');", (Object)strMessage);
        return strOutput;
    }

    public static String getCloseWindowScript() {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"$W.Close();");
        return strOutput;
    }

    public static String getSetDialogResult(String strValue) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"$W.DialogResult = '%1$s';", (Object)strValue);
        return strOutput;
    }

    public static String getSetReturnValue(String strKey, String strValue) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"$W.SetReturnValue('%1$s',%2$s);", (Object)strKey, (Object)strValue);
        return strOutput;
    }

    public static String getShowWindowScript(String strUrl, boolean bShowModal, int nWidth, int nHeight, String strParam) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"$APP.OpenWindow(\"%1$s\",%2$s,%3$s,%4$s,\"%5$s\");", (Object)strUrl, (Object)(bShowModal ? "true" : "false"), (Object)nWidth, (Object)nHeight, (Object)WebUtility.GetJSONText((String)strParam));
        return strOutput;
    }
}

