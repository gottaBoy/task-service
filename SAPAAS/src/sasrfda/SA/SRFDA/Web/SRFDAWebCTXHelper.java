/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  SA.SRFramework.Utility.StringHelper
 */
package SA.SRFDA.Web;

import SA.SRFDA.Web.ISRFDAWebContext;
import SA.SRFDA.Web.SRFDAWebContext;
import SA.SRFramework.Utility.StringHelper;
import java.util.Hashtable;
import java.util.Map;

public class SRFDAWebCTXHelper {
    public static boolean IsEmbedMode(ISRFDAWebContext webContext, boolean bDefault) {
        String strValue = webContext.GetParamValue("SRFEMBEDMODE");
        if (StringHelper.IsNullOrEmpty((String)strValue)) {
            return bDefault;
        }
        return StringHelper.Compare((String)strValue, (String)"TRUE", (boolean)true) == 0;
    }

    public static boolean IsTempDataMode(ISRFDAWebContext webContext, boolean bDefault) {
        String strValue = webContext.GetPostValue("SRFTEMPDATA");
        if (StringHelper.IsNullOrEmpty((String)strValue)) {
            strValue = webContext.GetParamValue("SRFTEMPDATA");
        }
        if (StringHelper.IsNullOrEmpty((String)strValue)) {
            return bDefault;
        }
        return StringHelper.Compare((String)strValue, (String)"TRUE", (boolean)true) == 0;
    }

    public static String GetTempKeyId(ISRFDAWebContext webContext) {
        return webContext.GetParamValue("SRFDATEMPKEYID");
    }

    public static String GetErrorCodeId(ISRFDAWebContext webContext) {
        return webContext.GetParamValue("SRFERRORCODEID");
    }

    public static String GetErrorInfo(ISRFDAWebContext webContext) {
        return webContext.GetParamValue("SRFERRORINFO");
    }

    public static String GetSRFGridViewEx(ISRFDAWebContext webContext) {
        String strValue = webContext.GetParamValue("SRFGRIDVIEWEX");
        return strValue;
    }

    public static String GetGridViewEx(ISRFDAWebContext webContext) {
        String strValue = webContext.GetParamValue("SRFGRIDVIEWEX");
        return strValue;
    }

    public static boolean IsNewDataMode(ISRFDAWebContext webContext) {
        String strValue = webContext.GetParamValue("SRFNEWDATA");
        return StringHelper.Compare((String)strValue, (String)"TRUE", (boolean)true) == 0;
    }

    public static String GetGridView(ISRFDAWebContext webContext) {
        String strValue = webContext.GetParamValue("SRFGRIDVIEW");
        return strValue;
    }

    public static String GetTreeView(ISRFDAWebContext webContext) {
        String strValue = webContext.GetParamValue("SRFTREEVIEW");
        return strValue;
    }

    public static String GetWFSubStep(ISRFDAWebContext webContext) {
        String strValue = webContext.GetParamValue("SRFWFSUBSTEP");
        return strValue;
    }

    public static String GetDESubWFId(ISRFDAWebContext webContext) {
        String strValue = webContext.GetParamValue("SRFDESUBWFID");
        return strValue;
    }

    public static String GetPDESubWFId(ISRFDAWebContext webContext) {
        String strValue = webContext.GetParamValue("SRFPDESUBWFID");
        return strValue;
    }

    public static String GetPageModel(ISRFDAWebContext webContext) {
        String strValue = webContext.GetParamValue("SRFPAGEMODEL");
        return strValue;
    }

    public static String GetMBPanelId(ISRFDAWebContext webContext) {
        String strValue = webContext.GetParamValue("SRFMBPANELID");
        return strValue;
    }

    public static String GetMBCtrlId(ISRFDAWebContext webContext) {
        String strValue = webContext.GetParamValue("SRFMBCTRLID");
        return strValue;
    }

    public static String GetMBListId(ISRFDAWebContext webContext) {
        String strValue = webContext.GetParamValue("SRFMBLISTID");
        return strValue;
    }

    public static String GetWFMode(ISRFDAWebContext webContext) {
        Object objValue = webContext.GetGlobalValue("SRFWFMODE");
        return objValue == null ? "" : objValue.toString();
    }

    public static String GetDEMainState(ISRFDAWebContext webContext) {
        return webContext.GetParamValue("SRFDEMAINSTATE");
    }

    public static String GetPDEMainState(ISRFDAWebContext webContext) {
        return webContext.GetParamValue("SRFPDEMAINSTATE");
    }

    public static String GetDEMainAction(ISRFDAWebContext webContext) {
        return webContext.GetParamValue("SRFDEMAINACTION");
    }

    public static String GetFormDigest(ISRFDAWebContext webContext) {
        return webContext.GetParamValue("SRFFORMDIGEST");
    }

    public static String GetDERIndexId(ISRFDAWebContext webContext) {
        return webContext.GetParamValue("SRFDERINDEXID");
    }

    public static String GetDERId(ISRFDAWebContext webContext) {
        return webContext.GetParamValue("SRFDERID");
    }

    public static String GetDER1NId(ISRFDAWebContext webContext) {
        return webContext.GetParamValue("SRFDER1NID");
    }

    public static String GetFilter(ISRFDAWebContext webContext) {
        return webContext.GetParamValue("SRFFILTER");
    }

    public static boolean IsCopyMode(ISRFDAWebContext webContext) {
        String strCopyMode = webContext.GetParamValue("SRFCOPYMODE");
        if (StringHelper.IsNullOrEmpty((String)strCopyMode)) {
            strCopyMode = webContext.GetParamValue("COPYMODE");
        }
        return StringHelper.Compare((String)strCopyMode, (String)"TRUE", (boolean)true) == 0;
    }

    public static String[] GetDAKeys(ISRFDAWebContext webContext) {
        String strValue = webContext.GetParamValue("SRFDAKEYS");
        if (StringHelper.IsNullOrEmpty((String)strValue) && StringHelper.IsNullOrEmpty((String)(strValue = webContext.GetParamValue("SRFDATAKEYS")))) {
            return null;
        }
        return strValue.split("[,]");
    }

    public static String GetDAKey(ISRFDAWebContext webContext) {
        String[] keys = SRFDAWebCTXHelper.GetDAKeys(webContext);
        if (keys != null && keys.length > 0) {
            return keys[0];
        }
        return "";
    }

    public static Hashtable<String, String> GetQueryParamsWithout(ISRFDAWebContext webContext, String strWithoutParams) {
        return SRFDAWebCTXHelper.GetQueryParamsWithout(webContext, strWithoutParams);
    }

    public static Hashtable<String, String> GetQueryParamsWithout(ISRFDAWebContext webContext, String strWithoutParams, Hashtable<String, String> params) {
        if (params == null) {
            params = new Hashtable();
        }
        String[] list = strWithoutParams.toUpperCase().split("[|]");
        Hashtable<String, String> notKeys = new Hashtable<String, String>();
        int i = 0;
        while (i < list.length) {
            notKeys.put(list[i], "");
            ++i;
        }
        for (Map.Entry entry : webContext.GetParams().entrySet()) {
            if (notKeys.containsKey(entry.getKey())) continue;
            params.put((String)entry.getKey(), (String)entry.getValue());
        }
        return params;
    }

    public static Hashtable<String, String> GetQueryParamsWithoutDAParams(ISRFDAWebContext webContext) {
        return SRFDAWebCTXHelper.GetQueryParamsWithoutDAParams(webContext, null);
    }

    public static Hashtable<String, String> GetQueryParamsWithoutDAParams(ISRFDAWebContext webContext, Hashtable<String, String> params) {
        if (params == null) {
            params = new Hashtable();
        }
        Hashtable<String, String> daParams = SRFDAWebContext.getDAParamMap();
        for (Map.Entry entry : webContext.GetParams().entrySet()) {
            if (daParams.containsKey(entry.getKey())) continue;
            params.put((String)entry.getKey(), (String)entry.getValue());
        }
        return params;
    }
}

