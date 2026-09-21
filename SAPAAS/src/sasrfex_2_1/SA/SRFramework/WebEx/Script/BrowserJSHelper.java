/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFramework.WebEx.Script;

import SA.SRFramework.Utility.StringHelper;
import SA.SRFramework.WebEx.Builder.StyleBuilder;

public class BrowserJSHelper {
    public static String getCloseWindowScript() {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"window.close();");
        return strOutput;
    }

    public static String getAlertMessageScript(String strMessage) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"alert('%1$s');", (Object)strMessage);
        return strOutput;
    }

    public static String getResetDialogReturnValue() {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"window.returnValue  = {};");
        return strOutput;
    }

    public static String getSetDialogReturnValue(String strKey, String strValue) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"window.returnValue.%1$s = %2$s;", (Object)strKey, (Object)strValue);
        return strOutput;
    }

    public static String getSetDialogReturnValue(String strValue) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"window.returnValue = %1$s;", (Object)strValue);
        return strOutput;
    }

    public static String getShowDialogScript(String strResult, String strURL, String strParam, int nWidth, int nHeight, String strResizable, String strScroll, String strStatus) {
        if (StringHelper.Length((String)strResult) == 0) {
            strResult = "_DIALOGRESULT";
        }
        if (StringHelper.Length((String)strParam) == 0) {
            strParam = "''";
        }
        StyleBuilder styleBuilder = new StyleBuilder();
        styleBuilder.setKeyToLowerCase(false);
        styleBuilder.AddStyle("dialogWidth", String.valueOf(Integer.toString(nWidth)) + "px");
        styleBuilder.AddStyle("dialogHeight", String.valueOf(Integer.toString(nHeight)) + "px");
        if (StringHelper.Length((String)strResizable) != 0) {
            styleBuilder.AddStyle("resizable", strResizable);
        }
        if (StringHelper.Length((String)strScroll) != 0) {
            styleBuilder.AddStyle("scroll", strScroll);
        }
        if (StringHelper.Length((String)strStatus) != 0) {
            styleBuilder.AddStyle("status", strStatus);
        }
        String strOutput = "";
        strOutput = StringHelper.Format((String)"var %1$s = window.showModalDialog(%2$s,%3$s,'%4$s');", (Object)strResult, (Object)strURL, (Object)strParam, (Object)styleBuilder.ToStyleList());
        return strOutput;
    }

    public static String getShowDialogScript(String strResult, String strURL, String strParam, String strStyle) {
        if (StringHelper.Length((String)strResult) == 0) {
            strResult = "_DIALOGRESULT";
        }
        if (StringHelper.Length((String)strParam) == 0) {
            strParam = "''";
        }
        String strOutput = "";
        strOutput = StringHelper.Format((String)"var %1$s = window.showModalDialog(%2$s,%3$s,'%4$s');", (Object)strResult, (Object)strURL, (Object)strParam, (Object)strStyle);
        return strOutput;
    }

    public static String getShowWindowScript(String strURL, String strName, String strFeather, boolean bReplace) {
        if (StringHelper.Length((String)strURL) == 0) {
            strURL = "''";
        }
        if (StringHelper.Length((String)strName) == 0) {
            strName = "''";
        }
        if (StringHelper.Length((String)strFeather) == 0) {
            strFeather = "''";
        }
        return StringHelper.Format((String)"window.open(%1$s,%2$s,%3$s,%4$s);", (Object)strURL, (Object)strName, (Object)strFeather, (Object)bReplace);
    }

    public static String getShowWindowScriptEx(String strURL, String strName, String strFeather, boolean bReplace, int nWidth, int nHeight) {
        if (StringHelper.Length((String)strURL) == 0) {
            strURL = "''";
        }
        if (StringHelper.Length((String)strName) == 0) {
            strName = "''";
        }
        if (StringHelper.Length((String)strFeather) == 0) {
            strFeather = "''";
        }
        return StringHelper.Format((String)"SRFUtility.openwin(%1$s,%2$s,%3$s,%4$s,%5$s,%6$s);", (Object)strURL, (Object)strName, (Object)strFeather, (Object)bReplace, (Object)nWidth, (Object)nHeight);
    }

    public static String getShowDialogScriptEx(String strResult, String strURL, String strParam, int nWidth, int nHeight, String strResizable, String strScroll, String strStatus) {
        if (StringHelper.Length((String)strResult) == 0) {
            strResult = "_DIALOGRESULT";
        }
        if (StringHelper.Length((String)strParam) == 0) {
            strParam = "''";
        }
        StyleBuilder styleBuilder = new StyleBuilder();
        styleBuilder.setKeyToLowerCase(false);
        styleBuilder.AddStyle("dialogWidth", String.valueOf(Integer.toString(nWidth)) + "px");
        styleBuilder.AddStyle("dialogHeight", String.valueOf(Integer.toString(nHeight)) + "px");
        if (StringHelper.Length((String)strResizable) != 0) {
            styleBuilder.AddStyle("resizable", strResizable);
        }
        if (StringHelper.Length((String)strScroll) != 0) {
            styleBuilder.AddStyle("scroll", strScroll);
        }
        if (StringHelper.Length((String)strStatus) != 0) {
            styleBuilder.AddStyle("status", strStatus);
        }
        String strOutput = "";
        strOutput = StringHelper.Format((String)"var %1$s = SRFUtility.showmodeldialog(%2$s,%3$s,'%4$s',%5$s,%6$s);", (Object)strResult, (Object)strURL, (Object)strParam, (Object)styleBuilder.ToStyleList(), (Object)nWidth, (Object)nHeight);
        return strOutput;
    }

    public static String getShowDialogScriptEx(String strResult, String strURL, String strParam, int nWidth, int nHeight, String strStyle) {
        if (StringHelper.Length((String)strResult) == 0) {
            strResult = "_DIALOGRESULT";
        }
        if (StringHelper.Length((String)strParam) == 0) {
            strParam = "''";
        }
        String strOutput = "";
        strOutput = StringHelper.Format((String)"var %1$s = SRFUtility.showmodeldialog(%2$s,%3$s,'%4$s',%5$s,%6$s);", (Object)strResult, (Object)strURL, (Object)strParam, (Object)strStyle, (Object)nWidth, (Object)nHeight);
        return strOutput;
    }

    public static String getShowDialogScriptEx(String strURL, String strParam, int nWidth, int nHeight, String strStyle) {
        if (StringHelper.Length((String)strParam) == 0) {
            strParam = "''";
        }
        String strOutput = "";
        strOutput = StringHelper.Format((String)"SRFUtility.showmodeldialog(%1$s,%2$s,'%3$s',%4$s,%5$s);", (Object)strURL, (Object)strParam, (Object)strStyle, (Object)nWidth, (Object)nHeight);
        return strOutput;
    }

    public static String getRemoveIframe(String strIframeId) {
        String strOutput = "";
        strOutput = StringHelper.Format((String)"SRFRemoveIframe('%1$s');", (Object)strIframeId);
        return strOutput;
    }
}

