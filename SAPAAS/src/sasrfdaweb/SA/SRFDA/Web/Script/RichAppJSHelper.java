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

public class RichAppJSHelper {
    public static final String DIALOGRESULT_OK = "OK";
    public static final String DIALOGRESULT_CANCEL = "CANCEL";
    public static final String DIALOGRESULT_NONE = "NONE";
    public static final String DIALOGRESULT_YES = "YES";
    public static final String DIALOGRESULT_NO = "NO";

    public static String getAlertMessageScript(String strPageModel, String strMessage) {
        String strOutput = "";
        if (StringHelper.Compare((String)strPageModel, (String)"SL", (boolean)true) == 0) {
            strOutput = StringHelper.Format((String)"alert('%1$s');", (Object)strMessage);
        }
        return strOutput;
    }

    public static String getCloseWindowScript(String strPageModel) {
        String strOutput = "";
        if (StringHelper.Compare((String)strPageModel, (String)"SL", (boolean)true) == 0) {
            strOutput = StringHelper.Format((String)"$W.Close();");
        }
        if (StringHelper.Compare((String)strPageModel, (String)"WinRT", (boolean)true) == 0) {
            strOutput = StringHelper.Format((String)"_W.Close \r\n");
        }
        return strOutput;
    }

    public static String getSetDialogResult(String strPageModel, String strValue) {
        String strOutput = "";
        if (StringHelper.Compare((String)strPageModel, (String)"SL", (boolean)true) == 0) {
            strOutput = StringHelper.Format((String)"$W.DialogResult = '%1$s';", (Object)strValue);
        }
        if (StringHelper.Compare((String)strPageModel, (String)"WinRT", (boolean)true) == 0) {
            strOutput = StringHelper.Format((String)"_W.DialogResult = '%1$s'\r\n", (Object)strValue);
        }
        return strOutput;
    }

    public static String getSetReturnValue(String strPageModel, String strKey, String strValue) {
        String strOutput = "";
        if (StringHelper.Compare((String)strPageModel, (String)"SL", (boolean)true) == 0) {
            strOutput = StringHelper.Format((String)"$W.SetReturnValue('%1$s',%2$s);", (Object)strKey, (Object)strValue);
        }
        if (StringHelper.Compare((String)strPageModel, (String)"WinRT", (boolean)true) == 0) {
            strOutput = StringHelper.Format((String)"_W.SetReturnValue '%1$s', %2$s\r\n ", (Object)strKey, (Object)strValue);
        }
        return strOutput;
    }

    public static String getShowWindowScript(String strPageModel, String strUrl, boolean bShowModal, int nWidth, int nHeight, String strParam) {
        String strOutput = "";
        if (StringHelper.Compare((String)strPageModel, (String)"SL", (boolean)true) == 0) {
            strOutput = StringHelper.Format((String)"$APP.OpenWindow(\"%1$s\",%2$s,%3$s,%4$s,\"%5$s\");", (Object)strUrl, (Object)(bShowModal ? "true" : "false"), (Object)nWidth, (Object)nHeight, (Object)WebUtility.GetJSONText((String)strParam));
        }
        return strOutput;
    }

    public static String getSetPageInfoScript(String strPageModel, String strInfo) {
        String strOutput = "";
        if (StringHelper.Compare((String)strPageModel, (String)"SL", (boolean)true) == 0) {
            strOutput = StringHelper.Format((String)"$P.setpageinfo('%1$s');", (Object)strInfo);
        }
        if (StringHelper.Compare((String)strPageModel, (String)"WinRT", (boolean)true) == 0) {
            strOutput = StringHelper.Format((String)"_P.setpageinfo '%1$s' \r\n", (Object)strInfo);
        }
        return strOutput;
    }

    public static String getSetPageDataScript(String strPageModel, String strData) {
        String strOutput = "";
        if (StringHelper.Compare((String)strPageModel, (String)"SL", (boolean)true) == 0) {
            strOutput = StringHelper.Format((String)"$P.setpagedata('%1$s');", (Object)strData);
        }
        if (StringHelper.Compare((String)strPageModel, (String)"WinRT", (boolean)true) == 0) {
            strOutput = StringHelper.Format((String)"_P.setpagedata '%1$s' \r\n", (Object)strData);
        }
        return strOutput;
    }
}

